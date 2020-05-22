package foo1;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class TestDraw2 {
    @SuppressWarnings("serial")
    private static void createAndShowGui() {
        final DrawPanel2 drawPanel = new DrawPanel2();

        JButton drawButton = new JButton(new AbstractAction("Draw!") {

            @Override
            public void actionPerformed(ActionEvent e) {
                drawPanel.resetBoxes();
            }
        });
        JPanel btnPanel = new JPanel();
        btnPanel.add(drawButton);

        JFrame frame = new JFrame("TestDraw2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(drawPanel);
        frame.getContentPane().add(btnPanel, BorderLayout.PAGE_END);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGui();
            }
        });
    }
}

@SuppressWarnings("serial")
class DrawPanel2 extends JPanel {

    private static final int BOX_COUNT = 5;
    private static final int TIMER_DELAY = 750;
    private static final int PREF_W = 600;
    private static final int PREF_H = PREF_W;
    private Random randGen = new Random();
    private Box[] boxes;
    private int box2draw = 0;

    public DrawPanel2() {
        setBackground(Color.YELLOW);

        boxes = new Box[BOX_COUNT];

        for (int count = 0; count < boxes.length; count++) {
            int x = randGen.nextInt(300);
            int y = randGen.nextInt(300);
            int w = randGen.nextInt(300);
            int h = randGen.nextInt(300);

            Color color = new Color(randGen.nextInt(256), randGen.nextInt(256),
                    randGen.nextInt(256));

            boxes[count] = new Box(x, y, w, h, color);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet()) {
            return super.getPreferredSize();
        }
        return new Dimension(PREF_W, PREF_H);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < box2draw; i++) {
            boxes[i].draw(g);
        }
    }

    public void resetBoxes() {
        boxes = new Box[BOX_COUNT];

        for (int count = 0; count < boxes.length; count++) {
            int x = randGen.nextInt(300);
            int y = randGen.nextInt(300);
            int w = randGen.nextInt(300);
            int h = randGen.nextInt(300);

            Color color = new Color(randGen.nextInt(256), randGen.nextInt(256),
                    randGen.nextInt(256));

            boxes[count] = new Box(x, y, w, h, color);
            box2draw = 0;
        }
        repaint();

        new Timer(TIMER_DELAY, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                box2draw++;
                if (box2draw > BOX_COUNT) {
                    box2draw = BOX_COUNT;
                    ((Timer) e.getSource()).stop();
                } 
                repaint();
            }
        }).start();
    }
}