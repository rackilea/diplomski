import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CirclesDemo {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new CirclesDemo();
            }
        });
    }

    public CirclesDemo() {
        JFrame frame = new JFrame();
        frame.add(panel);
        frame.add(createButton(), BorderLayout.PAGE_END);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private final DrawingPanel panel = new DrawingPanel();

    private JButton createButton() {
        JButton button = new JButton("Add Circle");
        button.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int[] circleValues = generateRandomValues(300, 300, 50, 150);
                int x = circleValues[0];
                int y = circleValues[1];
                int width = circleValues[2];
                int height = width;
                Circle circle = new Circle(x, y, width, height);
                panel.addCircle(circle);
            }
        });
        return button;
    }

    private int[] generateRandomValues(int maxX, int maxY, 
                                       int minSize, int maxSize) {
        Random random = new Random();
        int[] values = new int[3];
        values[0] = random.nextInt(maxX);
        values[1] = random.nextInt(maxY);
        values[2] = Math.min(random.nextInt(maxSize) + minSize, maxSize);
        return values;
    }

    class Circle {

        int x, y, width, height;

        public Circle(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
        }

        public void draw(Graphics g) {
            g.drawOval(x, y, width, height);
        }
    }

    class DrawingPanel extends JPanel {

        List<Circle> circles = new ArrayList<>();

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Circle circle : circles) {
                circle.draw(g);
            }
        }

        public void addCircle(Circle circle) {
            circles.add(circle);
            repaint();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }
    }
}