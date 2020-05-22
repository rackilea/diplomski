import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test1001 {

    public static void main(String[] args) {
        new Test1001();
    }

    public Test1001() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                try {
                    NestedScreen screen = new NestedScreen();
                    screen.setBackgroundLayer(ImageIO.read(getClass().getResource("/Sky.png")));

                    JFrame frame = new JFrame("Testing");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.add(screen);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException exp) {
                    exp.printStackTrace();
                }
            }
        });
    }

    public interface GraphicsEngineComponents {

    }

    public class NestedScreen extends Screen implements GraphicsEngineComponents {

        GroundPanel ground;
        ForeGroundPanel foreground;
        private PausePane pausePane;

        public NestedScreen() {

            ground = new GroundPanel();
            foreground = new ForeGroundPanel();
            pausePane = new PausePane();

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1;
            gbc.weighty = 1;
            gbc.fill = GridBagConstraints.BOTH;

            add(pausePane, gbc);
            add(foreground, gbc);
            add(ground, gbc);

            MouseAdapter handler = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    pausePane.setVisible(!pausePane.isVisible());
                }
            };

            addMouseListener(handler);
            foreground.addMouseListener(handler);
            ground.addMouseListener(handler);

        }

        public GroundPanel getGroundLayer() {
            return ground;
        }

        public ForeGroundPanel getForegroundLayer() {
            return foreground;
        }

        public void setBackgroundLayer(BufferedImage background) {
            super.setBackgroundLayer(background);
        }

        public class GroundPanel extends JPanel {

            public GroundPanel() {
                setOpaque(false);
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.GREEN);
                g.fillRect(0, getHeight() - 200, getWidth(), 200);
            }

        }

        public class PausePane extends JPanel {

            private JLabel label;

            public PausePane() {
                setVisible(false);
                setOpaque(false);
                setBackground(new Color(0, 0, 0, 128));
                setLayout(new GridBagLayout());

                label = new JLabel("Paused");
                label.setHorizontalAlignment(JLabel.CENTER);
                label.setVerticalAlignment(JLabel.CENTER);
                Font font = label.getFont();
                font = font.deriveFont(Font.BOLD, 48f);
                label.setFont(font);
                label.setForeground(Color.WHITE);
                add(label);
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(getBackground());
                g.fillRect(0, 0, getWidth(), getHeight());
            }

        }

        public class ForeGroundPanel extends JPanel {

            private BufferedImage pony;

            public ForeGroundPanel() {
                setOpaque(false);
                try {
                    pony = ImageIO.read(getClass().getResource("/Pony.png"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (pony != null) {
                    int x = (getWidth() - pony.getWidth()) / 2;
                    int y = getHeight() - 200 - (pony.getHeight() / 2);
                    g.drawImage(pony, x, y, this);
                }
            }

        }
    }

    public class Screen extends JPanel implements GraphicsEngineComponents {

        private BufferedImage background;

        public Screen() {
        }

        @Override
        public String toString() {
            return "Screen{" + "background=" + background + '}';
        }

        public BufferedImage getBackgroundPicture() {
            return background;
        }

        @Override
        public Dimension getPreferredSize() {
            return background == null ? super.getPreferredSize() : new Dimension(background.getWidth(), background.getHeight());
        }

        protected void setBackgroundLayer(BufferedImage background) {
            if (background != null && background.getHeight() != 0 && background.getWidth() != 0) {
                this.background = background;
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (background != null) {
                g.drawImage(background, 0, 0, this);
            }
        }
    }

}