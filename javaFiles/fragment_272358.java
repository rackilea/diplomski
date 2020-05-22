import java.awt.AWTException;
import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PrintScreen01 {

    public static void main(String[] args) {
        new PrintScreen01();
    }

    private Timer timer;

    public PrintScreen01() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                final PrintPane printPane = new PrintPane();

                final JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(printPane);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.addComponentListener(new ComponentAdapter() {

                    @Override
                    public void componentMoved(ComponentEvent e) {
                        timer.restart();
                    }

                    @Override
                    public void componentResized(ComponentEvent e) {
                        timer.restart();
                    }

                });
                timer = new Timer(250, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (frame.isVisible()) {
                            takeSnapShot(frame, printPane);
                        }
                    }
                });
                timer.setRepeats(false);
                frame.setVisible(true);
//                takeSnapShot(frame, printPane);
            }
        });
    }

    public void takeSnapShot(JFrame frame, PrintPane pane) {

        Rectangle bounds = new Rectangle(pane.getLocationOnScreen(), pane.getSize());
        frame.setVisible(false);
        new SnapShotWorker(frame, pane, bounds).execute();

    }

    public class SnapShotWorker extends SwingWorker<BufferedImage, BufferedImage> {

        private JFrame frame;
        private PrintPane pane;
        private Rectangle captureBounds;

        public SnapShotWorker(JFrame frame, PrintPane pane, Rectangle bounds) {
            this.frame = frame;
            this.pane = pane;
            captureBounds = bounds;
        }

        @Override
        protected BufferedImage doInBackground() throws Exception {

            Thread.sleep(125);

            BufferedImage snapShot = null;
            try {
                Robot bot = new Robot();
                snapShot = bot.createScreenCapture(captureBounds);
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
            Thread.sleep(125);
            return snapShot;
        }

        @Override
        protected void done() {
            try {
                BufferedImage snapShot = get();
                pane.setSnapShot(snapShot);
                frame.setVisible(true);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            }
        }



    }

    public class PrintPane extends JPanel {

        private BufferedImage background;

        public PrintPane() {
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public void setSnapShot(BufferedImage img) {
            background = img;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (background != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
                g2d.drawImage(background, 0, 0, this);
                g2d.dispose();
            }
        }

    }

}