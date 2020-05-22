import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Tester {

    public static void main(String[] args) {
        new Tester();
    }

    public Tester() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private JPanel panel;
        private JButton button;
        private JLabel label;
        private ShapePane shapePane;

        public TestPane() {
            setLayout(new BorderLayout());
            button = new JButton("Rectangle");
            panel = new JPanel();
            label = new JLabel();

            button.setVisible(true);
            panel.add(button);
            panel.add(label);

            shapePane = new ShapePane();

            add(shapePane);
            add(panel, BorderLayout.SOUTH);

            class ClickListener implements ActionListener {

                private int X = 20;
                private int Y = 20;

                @Override
                public void actionPerformed(ActionEvent arg0) {
                    int width = shapePane.getWidth();
                    int height = shapePane.getHeight();

                    int x = (int)(Math.random() * (width - 20)) + 10;
                    int y = (int)(Math.random() * (height - 20)) + 10;

                    int w = (int)(Math.random() * (width - x));
                    int h = (int)(Math.random() * (height - y));

                    shapePane.add(new Rectangle(x, y, w, h));
                }

            }
            ActionListener listener = new ClickListener();
            button.addActionListener(listener);
        }

    }

    public class ShapePane extends JPanel {

        private List<Shape> shapes;

        public ShapePane() {
            shapes = new ArrayList<>(25);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public void add(Rectangle rectangle) {
            shapes.add(rectangle);
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.RED);
            for (Shape shape : shapes) {
                g2.draw(shape);
            }
        }
    }
}