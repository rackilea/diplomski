import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import javax.swing.JFrame;
import javax.swing.JPanel;
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

        private ReentrantLock shapesLock = new ReentrantLock();
        private List<Ellipse2D> shapes;

        public TestPane() {
            shapes = new ArrayList<>(25);
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    shapesLock.lock();
                    try {
                        shapes.add(new Ellipse2D.Double(e.getX() - 5, e.getY() - 5, 10, 10));
                    } finally {
                        shapesLock.unlock();
                    }
                }
            });

            Thread t = new Thread(new Runnable() {
                private Map<Shape, Double> deltas = new HashMap<>();

                @Override
                public void run() {
                    while (true) {
                        try {
                            shapesLock.lock();
                            try {
                                Rectangle containerBounds = getBounds();
                                containerBounds.setLocation(0, 0);
                                Iterator<Ellipse2D> it = shapes.iterator();
                                while (it.hasNext()) {
                                    Ellipse2D shape = it.next();
                                    Rectangle2D bounds = shape.getBounds2D();
                                    double y = bounds.getY();
                                    Double delta = deltas.get(shape);
                                    if (delta == null) {
                                        delta = 0d;
                                    }
                                    y += delta;
                                    shape.setFrame(bounds.getX(), y, bounds.getWidth(), bounds.getHeight());
                                    if (containerBounds.contains(shape.getBounds())) {
                                        delta = Math.min(delta + 0.25, 6d);
                                        deltas.put(shape, delta);
                                    } else {
                                        it.remove();
                                    }
                                }
                            } finally {
                                shapesLock.unlock();
                            }
                            repaint();
                            Thread.sleep(40);
                        }   catch (InterruptedException ex) {
                        }
                    }
                }
            });
            t.setDaemon(false);
            t.start();
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            shapesLock.lock();
            try {
                for (Ellipse2D shape : shapes) {
                    g2d.fill(shape);
                }
            } finally {
                shapesLock.unlock();
            }
            g2d.dispose();
        }

    }

}