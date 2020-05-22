import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

public class CircleList extends JPanel implements ActionListener, Runnable {

    private static final int INTERVAL = 20;

    private static final int INITIAL_DIAMETR = 20;

    private int actualXPos;

    private final List<Circle> circleList = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new CircleList());
    }

    @Override
    public void run() {
        JFrame frm = new JFrame(getClass().getSimpleName());
        frm.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frm.getContentPane().add(this);
        frm.pack();
        frm.setLocationRelativeTo(null);
        frm.setVisible(true);
    }

    public CircleList() {
        setLayout(new BorderLayout());
        setPreferredSize(new Dimension(500, 500));
        setBackground(Color.gray);
        JButton addCircle = new JButton("Add Circle");
        add(addCircle, BorderLayout.SOUTH);
        addCircle.addActionListener(this);
        addCircle();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Circle c : circleList) {
            c.paint(g);
        }
    }

    private void addCircle() {

        Circle circle = new Circle();

        int num = circleList.size();
        circle.x1 = 40 + actualXPos;
        circle.y1 = 30;
        circle.w = 30 + INITIAL_DIAMETR * (num + 1);
        circle.h = 30 + INITIAL_DIAMETR * (num + 1);
        circle.color = num % 2 == 0 ? Color.BLACK : Color.WHITE;
        circleList.add(circle);
        actualXPos += circle.w + INTERVAL;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (circleList.size() == 4) {
            circleList.clear();
            actualXPos = 0;
        }
        addCircle();
        repaint();
    }

    private static class Circle {
        private int x1;

        private int y1;

        private int w;

        private int h;

        private Color color;

        public void paint(Graphics g) {
            g.setColor(color);
            g.fillOval(x1, y1, w, h);
        }
    }
}