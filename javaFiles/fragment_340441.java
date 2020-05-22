import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Scanner;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class SwingBot {
    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setSize(400, 400);
        frame.setTitle("SwingBot");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Robot r = new Robot();

        frame.add(r);

        frame.setVisible(true);

        Scanner in = new Scanner(System.in);
        boolean repeat = true;
        System.out.println();
        while (repeat) {
            String str = in.next();
            String direc = str.toLowerCase();
            if (direc.equals("right")) {
                r.moveBot(10, 0);
            } else if (direc.equals("left")) {
                r.moveBot(-10, 0);
            } else if (direc.equals("up")) {
                r.moveBot(0, -10);
            } else if (direc.equals("down")) {
                r.moveBot(0, 10);
            } else if (direc.equals("exit")) {
                repeat = false;
            }
        }

    }

    public static class Robot extends JComponent {
        int x = 45;
        int y = 60;

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            Ellipse2D e = new Ellipse2D.Double(x - 25, y - 40, 100, 50);

            g2.setColor(Color.BLACK);
            g2.fillOval(x, y, 50, 50);
            g2.fill(e);

            g2.setColor(Color.RED);
            g2.fillOval(x - 5, y - 20, 20, 20);
            g2.fillOval(x + 35, y - 20, 20, 20);

        }

        public void moveBot(int x, int y) {

            setX(getX() + x);
            setY(getY() + y);
            repaint();
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

    }

}