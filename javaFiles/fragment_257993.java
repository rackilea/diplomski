import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class PaintComponentTest {

    public static void main(String[] args) {
        new PaintComponentTest();
    }

    private int time = 0;

    public PaintComponentTest() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                final CustomClockLabel counter = new CustomClockLabel("/icons/0.png");
                Timer timer = new Timer(1000, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        time++;
                        if (time > 9) {
                            time = 0;
                        }
                        counter.init("/icons/" + Integer.toString(time) + ".png");
                        counter.repaint();
                    }
                });
                timer.start();

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(counter);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class CustomClockLabel extends JPanel {

        BufferedImage background;
        String Uri;

        public CustomClockLabel(String Uri) {
            init(Uri);
            this.Uri = Uri;
        }

        public void init(String Uri) {
            try {
                URL inp = getClass().getResource(Uri);
                background = ImageIO.read(inp);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(100, 100);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            if (background != null) {
                g2.drawImage(background, 0, 0, getWidth(), getHeight(), this);
            }
            g2.dispose();
        }
    }

}