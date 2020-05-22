import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class CityScape extends JPanel {

    Buildings a = new Buildings();
    UFO b = new UFO();

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        a.paint(g);
        b.paint(g);
    }

    public void move() {
        b.move();
    }

    public static void main(String[] args) throws InterruptedException {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Frame");
                CityScape jpe = new CityScape();
                frame.add(jpe);
                frame.setSize(800, 750);
                frame.setBackground(Color.BLACK);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                System.out.println(frame.getContentPane().getSize());

                Timer timer = new Timer(10, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jpe.move(); //Updates the coordinates
                        jpe.repaint(); //Calls the paint method
                    }
                });
                timer.start();
            }
        });
    }

    public class Buildings {

        private int maxX = 784;
        private int maxY = 712;

        private List<Building> buildings;

        public Buildings() {
            buildings = new ArrayList<>(25);
            for (int i = 10; i < 634; i += 10)//buildings
            {
                int width = (int) (Math.random() * 100 + 100);
                int height = (int) (Math.random() * 350 + 100);
                int x = i;
                int y = maxY - height;

                buildings.add(new Building(x, y, width, height));
            }
        }

        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            for (Building building : buildings) {
                building.paint(g2d);
            }
        }
    }

    public static class Building {

        protected static final Color TRANS_YELLOW = new Color(255, 255, 0, 59);

        private int x, y, width, height;
        private List<Light> lights;

        public Building(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;

            lights = new ArrayList<>(25);
            int rows = Math.round((height) / 25);
            int columns = Math.round(width / 25);

            for (int j = 1; j <= columns; j++)//windows
            {
                for (int k = 1; k <= rows; k++) {
                    Color color = null;
                    if (Math.random() < 0.7) {
                        color = Color.YELLOW;
                    } else {
                        color = TRANS_YELLOW;
                    }
                    lights.add(new Light(x + 5 * j + 20 * (j - 1), y + 5 * k + 20 * (k - 1), color));
                }
            }
        }

        public void paint(Graphics2D g2d) {
            g2d.setColor(Color.GRAY);
            g2d.drawRect(x, y, width, height);
            g2d.fillRect(x, y, width, height);
            for (Light light : lights) {
                light.paint(g2d);
            }
        }

        public class Light {

            private int x, y;
            private Color color;

            public Light(int x, int y, Color color) {
                this.x = x;
                this.y = y;
                this.color = color;
            }

            public void paint(Graphics2D g2d) {
                g2d.setColor(Color.BLACK);
                g2d.fillRect(x, y, 20, 20);
                g2d.setColor(color);
                g2d.fillRect(x, y, 20, 20);
            }
        }

    }

    public class UFO {

        private int x = 20; //x and y coordinates of the ball
        private int y = 20;
        private int xa = 1;

        public void move() //Increase both the x and y coordinates
        {
            if (x + xa < 0) {
                xa = 1;
            }
            if (x + xa > 784 - 75) {
                xa = -1;
            }
            x = x + xa;
        }

        public void paint(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.LIGHT_GRAY);
            g2d.fillOval(x, y, 75, 25); //Draw the ball at the desired point
        }
    }
}