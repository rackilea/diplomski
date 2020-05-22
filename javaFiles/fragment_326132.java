import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                TestPane testPane = new TestPane();
                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(testPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        testPane.play();
                    }
                });
            }
        });
    }

    public class TestPane extends JPanel {

        private List<Animatable> animations;
        private Animatable animation;

        private Timer timer;

        public TestPane() {
            animations = new ArrayList<>(25);
            animations.add(new CircleAnimation(Color.RED));
            animations.add(new CircleAnimation(Color.BLUE));

            timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (animation == null) {
                        animation = animations.remove(0);
                    }
                    if (animation.update(getBounds())) {
                        if (animations.isEmpty()) {
                            ((Timer)e.getSource()).stop();
                        } else {
                            animation = animations.remove(0);
                        }
                    }
                    repaint();
                }
            });
        }

        public void play() {
            timer.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (animation != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                animation.paint(g2d);
                g2d.dispose();
            }
        }

    }

    public interface Animatable {
        public boolean update(Rectangle bounds);
        public void paint(Graphics2D g2d);
    }

    public class CircleAnimation implements Animatable {
        private Color color;
        private Ellipse2D circle;
        private double delta = -1;

        public CircleAnimation(Color color) {
            this.color = color;
        }

        @Override
        public boolean update(Rectangle bounds) {
            if (circle == null) {
                circle = new Ellipse2D.Double(bounds.width, (bounds.height / 2) - 10, 20, 20);
            }
            Rectangle rect = circle.getBounds();
            rect.x += delta;
            circle.setFrame(rect);
            return rect.x + 20 < bounds.x;
        }

        @Override
        public void paint(Graphics2D g2d) {
            if (circle == null) {
                return;
            }
            g2d.setColor(color);
            g2d.fill(circle);
        }
    }

}