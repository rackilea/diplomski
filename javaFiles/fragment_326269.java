import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CircleChangeColor extends JPanel {
    private Ellipse2D circle = new Ellipse2D.Double(0, 0, 200, 200);
    private Color color = Color.blue;

    public CircleChangeColor() {
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                if (circle.contains(e.getPoint())) {
                    changeColor();
                }
            }
        });
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(color);
        g2.fill(circle);
    }

    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    public void changeColor() {
        if (color == Color.BLUE) {
            color = Color.RED;
        } else {
            color = color.BLUE;
        }
        repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new CircleChangeColor());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });

    }
}