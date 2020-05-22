import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

public class LayoutExample extends JPanel {
    private static final long serialVersionUID = 1L;
    private BufferedImage background;
    private JButton startButton = new JButton("Start");
    private JButton exitButton = new JButton("Exit");
    private JComboBox<String> combo = new JComboBox<>(new String[] {"1280 x 780 HD"});

    public LayoutExample(BufferedImage background) {
        this.background = background;

        JPanel rightLowerPanel = new JPanel(new GridLayout(0, 1, 5, 5));
        rightLowerPanel.setOpaque(false);
        rightLowerPanel.add(combo);
        rightLowerPanel.add(startButton);
        rightLowerPanel.add(exitButton);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.setOpaque(false);
        rightPanel.add(rightLowerPanel, BorderLayout.PAGE_END);

        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setLayout(new BorderLayout());
        add(rightPanel, BorderLayout.LINE_END);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (background != null) {
            int w = background.getWidth();
            int h = background.getHeight();
            return new Dimension(w, h);
        }
        return super.getPreferredSize();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }

    private static void createAndShowGui() {
        String imgPath = "https://pbs.twimg.com/media/DRHUe_tV4AA96G4.jpg";
        BufferedImage img = null;
        try {
            URL imageUrl = new URL(imgPath);
            img = ImageIO.read(imageUrl);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        LayoutExample mainPanel = new LayoutExample(img);
        JFrame frame = new JFrame("LayoutExample");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }
}