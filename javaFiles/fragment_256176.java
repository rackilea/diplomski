import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Thrust {

    public static void main(String[] args) {
        new Thrust();
    }

    public Thrust() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private BufferedImage viper;
        private BufferedImage thrust;
        private BufferedImage maxThrust;

        private float[] power = new float[]{0f, 0f, 0f};

        public TestPane() {
            try {
                viper = ImageIO.read(getClass().getResource("/Viper01.png"));
                thrust = ImageIO.read(getClass().getResource("/ThrusterBurn01.png"));
                maxThrust = ImageIO.read(getClass().getResource("/MaxBurn01.png"));

                InputMap im = getInputMap(WHEN_IN_FOCUSED_WINDOW);
                ActionMap am = getActionMap();

                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_1, 0), "Thruster1Up");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_1, KeyEvent.SHIFT_DOWN_MASK), "Thruster1Down");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_2, 0), "Thruster2Up");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_2, KeyEvent.SHIFT_DOWN_MASK), "Thruster2Down");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_3, 0), "Thruster3Up");
                im.put(KeyStroke.getKeyStroke(KeyEvent.VK_3, KeyEvent.SHIFT_DOWN_MASK), "Thruster3Down");

                am.put("Thruster1Up", new ThrustAction(0, 0.1f));
                am.put("Thruster1Down", new ThrustAction(0, -0.1f));
                am.put("Thruster2Up", new ThrustAction(1, 0.1f));
                am.put("Thruster2Down", new ThrustAction(1, -0.1f));
                am.put("Thruster3Up", new ThrustAction(2, 0.1f));
                am.put("Thruster3Down", new ThrustAction(2, -0.1f));

            } catch (IOException exp) {
                exp.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(1000, 400);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (viper != null && thrust != null && maxThrust != null) {
                Graphics2D g2d = (Graphics2D) g.create();

                int yOffset = (getHeight() - viper.getHeight()) / 2;

                Point port[] = new Point[]{new Point(574, 111), new Point(576, 159), new Point(574, 210)};
                for (int index = 0; index < 3; index++) {
                    BufferedImage image = thrust;
                    if (power[index] >= 1f) {
                        image = maxThrust;
                    }
                    float progress = Math.min(Math.max(0, power[index]), 1f);
                    int width = image.getWidth();
                    int minWidth = (int)(width * 0.1f);
                    width -= minWidth;
                    width = (int)(width - (width * (1f - progress)));
                    width = Math.max(minWidth, width);
                    int x = port[index].x;
                    int y = yOffset + port[index].y - (image.getHeight()/ 2);
                    image = image.getSubimage(image.getWidth() - width, 0, width, image.getHeight());
                    g2d.drawImage(image, x, y, this);
                }

                int x = 0;
                g2d.drawImage(viper, x, yOffset, this);
                g2d.dispose();
            }
        }

        public class ThrustAction extends AbstractAction {

            private int thruster;
            private float modifer;

            public ThrustAction(int thruster, float modifier) {
                this.thruster = thruster;
                this.modifer = modifier;
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                power[thruster] += modifer;
                power[thruster] = Math.min(Math.max(power[thruster], 0f), 1f);
                repaint();
            }

        }

    }
}