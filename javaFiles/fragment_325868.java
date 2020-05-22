import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DrawRectangles {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                DrawRectangles dr = new DrawRectangles(new int[]{2, 4, 6, 8});
                dr.setUpFrame();

            }
        });
    }

    JFrame frame;
    DrawPanel panel;
    Random randomGenerator = new Random();
    int[] newWidth;

    DrawRectangles(int[] width) {
        this.newWidth = width;
    }

    public void setUpFrame() {
        frame = new JFrame();
        frame.setSize(500, 100);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DrawPanel panel = new DrawPanel();
        for (int x = 0; x < newWidth.length; x++) {
            int red = randomGenerator.nextInt(255);
            int green = randomGenerator.nextInt(255);
            int blue = randomGenerator.nextInt(255);
            panel.addRectangle(new Color(red, green, blue), newWidth[x]);
        }
        frame.setSize(200, 200);
        frame.add(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public class MyRectangle {

        private Color color;
        private Rectangle rectangle;

        public MyRectangle(Color color, int width) {
            this.color = color;
            rectangle = new Rectangle(width, 10, width, 30);
        }

        public Color getColor() {
            return color;
        }

        public Rectangle getRectangle() {
            return rectangle;
        }

        public void draw(Graphics2D g2d) {
            g2d.setColor(color);
            g2d.fill(rectangle);
        }
    }

    public class DrawPanel extends JPanel {

        private List<MyRectangle> rectangles;

        public DrawPanel() {
            rectangles = new ArrayList<>();
        }

        public void addRectangle(Color color, int width) {
            rectangles.add(new MyRectangle(color, width));
        }

        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2d = (Graphics2D) g.create();
            for (MyRectangle rect : rectangles) {
                rect.draw(g2d);
            }
            g2d.dispose();
        }
    }
}