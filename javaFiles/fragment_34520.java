import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class PaintOver {

    public static void main(String[] args) {
        new PaintOver();
    }

    public PaintOver() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new MapPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

            }
        });
    }

    public class MapPane extends JPanel {

        private BufferedImage background;
        private BufferedImage foreground;

        public MapPane() {
            try {
                background = ImageIO.read(getClass().getResource("/TreasureMap.png"));
                foreground = new BufferedImage(background.getWidth(), background.getHeight(), BufferedImage.TYPE_INT_ARGB);
            } catch (Exception e) {
                e.printStackTrace();
            }

            MouseAdapter mouseHandler = new MouseAdapter() {
                private Point startPoint;

                @Override
                public void mousePressed(MouseEvent e) {
                    startPoint = e.getPoint();
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    startPoint = null;
                }

                @Override
                public void mouseDragged(MouseEvent e) {
                    Point endPoint = e.getPoint();
                    Graphics2D g2d = foreground.createGraphics();

                    Point offset = getOffset();

                    Point from = new Point(startPoint);
                    from.translate(-offset.x, -offset.y);
                    Point to = new Point(endPoint);
                    to.translate(-offset.x, -offset.y);
                    g2d.setColor(Color.RED);
                    g2d.setStroke(new BasicStroke(4, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                    g2d.draw(new Line2D.Float(from, to));
                    g2d.dispose();
                    startPoint = endPoint;
                    repaint();
                }
            };

            addMouseListener(mouseHandler);
            addMouseMotionListener(mouseHandler);

        }

        @Override
        public Dimension getPreferredSize() {
            return background == null ? super.getPreferredSize() : new Dimension(background.getWidth(), background.getHeight());
        }

        protected Point getOffset() {
            Point p = new Point();
            if (background != null) {
                p.x = (getWidth() - background.getWidth()) / 2;
                p.y = (getHeight() - background.getHeight()) / 2;
            }
            return p;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (background != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                Point offset = getOffset();

                g2d.drawImage(background, offset.x, offset.y, this);
                g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
                g2d.drawImage(foreground, offset.x, offset.y, this);
                g2d.dispose();
            }
        }
    }
}