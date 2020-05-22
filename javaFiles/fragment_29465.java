import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class DragMe {

    public static void main(String[] args) {
        new DragMe();
    }

    public DragMe() {
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

        private Map<Image, Point> locations;

        public TestPane() {
            locations = new HashMap<>(25);
            try {
                locations.put(ImageIO.read(getClass().getResource("/Pony.png")), new Point(0, 0));
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            MouseAdapter ma = new MouseAdapter() {

                private Image dragImage;
                private Point clickOffset;

                @Override
                public void mousePressed(MouseEvent e) {
                    for (Map.Entry<Image, Point> entry : locations.entrySet()) {
                        Image image = entry.getKey();
                        Point point = entry.getValue();
                        Rectangle bounds = new Rectangle(
                                        point.x, point.y,
                                        image.getWidth(TestPane.this), image.getHeight(TestPane.this));
                        if (bounds.contains(e.getPoint())) {
                            dragImage = image;
                            clickOffset = new Point(point.x - e.getPoint().x, point.y - e.getPoint().y);
                            break;
                        }
                    }
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    dragImage = null;
                    clickOffset = null;
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    if (dragImage != null) {
                        Point dragPoint = new Point(e.getPoint());
                        dragPoint.x += clickOffset.x;
                        dragPoint.y += clickOffset.y;

                        locations.put(dragImage, dragPoint);
                        repaint();
                    }
                }

            };

            addMouseListener(ma);
            addMouseMotionListener(ma);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            for (Map.Entry<Image, Point> entry : locations.entrySet()) {
                Point point = entry.getValue();
                g2d.drawImage(entry.getKey(), point.x, point.y, this);
            }
            g2d.dispose();
        }

    }

}