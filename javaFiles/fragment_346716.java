import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;

public class ImageByDrawing {
    public ImageByDrawing() {
        ImagePanel imagePanel = new ImagePanel();
        imagePanel.setBorder(new TitledBorder("Drawn Image onto JPanel"));

        JCheckBox germanBox = new JCheckBox("German");
        germanBox.setOpaque(false);
        JCheckBox englishBox = new JCheckBox("English");
        englishBox.setOpaque(false);
        JPanel boxPanel = new JPanel();
        boxPanel.setBorder(new TitledBorder("JPanel with default FlowLayout"));
        boxPanel.setOpaque(false);
        boxPanel.add(germanBox);
        boxPanel.add(englishBox);

        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.add(imagePanel, BorderLayout.CENTER);
        centerPanel.add(boxPanel, BorderLayout.SOUTH);
        centerPanel.setBorder(new TitledBorder("JPanel with BorderLayout"));
        centerPanel.setOpaque(false);

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.add(centerPanel);
        mainPanel.setBorder(new TitledBorder("JPanel with GridBagLayout"));
        mainPanel.setBackground(new Color(216,252,202));

        JFrame frame = new JFrame();
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public class ImagePanel extends JPanel {
        BufferedImage img;
        int dWidth;
        int dHeight;
        public ImagePanel() {
            try {
                img = ImageIO.read(getClass().getResource("/resources/stackblack.jpg"));
                dWidth = img.getWidth();
                dHeight = img.getHeight();
            } catch (IOException ex) {
                Logger.getLogger(ImageByDrawing.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g); 
            g.drawImage(img, 0, 0, img.getWidth(), img.getHeight(), this);
        }
        @Override
        public Dimension getPreferredSize() {
            return (img == null) ? new Dimension(300, 300) : new Dimension(dWidth, dHeight);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                new ImageByDrawing();
            }
        });
    }
}