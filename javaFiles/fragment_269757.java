import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JApplet;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CircleApplet extends JApplet {

    @Override
    public void init() {
        add(new Circle());
    }

    public class Circle extends JPanel {

        private static final int D_W = 500;
        private static final int D_H = 500;

        int x = 0;
        int y = 0;

        public Circle() {
            setBackground(Color.BLACK);

            Timer timer = new Timer(50, new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    x += 5;
                    y += 5;
                    repaint();
                }
            });
            timer.start();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.BLUE);
            g.fillOval(x, y, 20, 20);

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(D_W, D_H);
        }

    }
}