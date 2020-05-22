import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class X {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JPanel() {

            private final int SIZE = 200;
            private final int INSET = 20;

            @Override
            public Dimension getPreferredSize() {
                return new Dimension(SIZE, SIZE);
            }

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;

                g2.setColor(Color.blue);
                Line2D line1 = new Line2D.Double(INSET, INSET,
                    getWidth() - INSET, getHeight() - INSET);
                Line2D line2 = new Line2D.Double(getWidth() - INSET,
                    INSET, INSET, getHeight() - INSET);
                g2.setStroke(new BasicStroke(16,
                    BasicStroke.CAP_ROUND,
                    BasicStroke.JOIN_BEVEL));
                g2.draw(line1);
                g2.draw(line2);
            }
        });
        frame.pack();
        frame.setVisible(true);
    }
}