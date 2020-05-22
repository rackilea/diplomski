import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Test {

    class Background extends JComponent {

        private BufferedImage bg;

        public Background() {
            try {
                bg = ImageIO.read(new File("/path/to/your/image"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            setLayout(new BorderLayout());
        }

        @Override
        public Dimension getPreferredSize() {
            return bg == null ? super.getPreferredSize() : new Dimension(bg.getWidth(), bg.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (bg != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                g2d.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
                g2d.dispose();
            }
        }
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setContentPane(new Background());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setUndecorated(true);

                JPanel panel = new JPanel(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                panel.add(new JLabel("This is a label, don't I look pretty"), gbc);
                JButton selectKey = new JButton("Select KeyIMG");
                panel.add(selectKey, gbc);
                panel.setOpaque(false);

                frame.add(panel);

                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static void main(String... Args) {
        new Test();
    }

}