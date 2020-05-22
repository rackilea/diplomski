import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.*;

@SuppressWarnings("serial")
public class SnakesAndLaddersProgram extends JPanel {
    public static final String GAME_BOARD_PATH = "http://www.righttoremain.org."
            + "uk/blog/wp-content/uploads/2015/11/snakesladders.jpg";
    public static final String GAME_LOGO_PATH = "https://loteries.lotoquebec.com"
            + "/loteries/___W9a9e8ef6-0c97-4d1b-a4c3-2588fee936d3___.png";
    private static final double BOARD_SCALE = 0.5; // online images too big
    private static final double LOGO_SCALE = 0.3; // online images too big
    private ImagePanel imagePanel = null;

    public SnakesAndLaddersProgram() throws IOException {
        URL gameBoardUrl = new URL(GAME_BOARD_PATH);
        Image gameBoard = ImageIO.read(gameBoardUrl);
        // scale to size:
        int w = (int) (gameBoard.getWidth(this) * BOARD_SCALE);
        int h = (int) (gameBoard.getHeight(this) * BOARD_SCALE);
        gameBoard = gameBoard.getScaledInstance(w, h, Image.SCALE_DEFAULT);        
        imagePanel = new ImagePanel(gameBoard);

        URL logoUrl = new URL(GAME_LOGO_PATH);
        Image logo = ImageIO.read(logoUrl);
        // scale to size:
        w = (int) (logo.getWidth(this) * LOGO_SCALE);
        h = (int) (logo.getHeight(this) * LOGO_SCALE);
        Icon logoIcon = new ImageIcon(logo);
        JLabel logoLabel = new JLabel(logoIcon);
        JPanel westPanel = new JPanel();
        westPanel.add(logoLabel);

        setLayout(new BorderLayout());
        add(imagePanel, BorderLayout.CENTER);
        add(westPanel, BorderLayout.LINE_START);
    }

    private static void createAndShowGui() {
        SnakesAndLaddersProgram mainPanel = null;
        try {
            mainPanel = new SnakesAndLaddersProgram();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(-1);
        }

        JFrame frame = new JFrame("Snakes And Ladders");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}

@SuppressWarnings("serial")
class ImagePanel extends JPanel {
    private Image image;

    public ImagePanel() {

    }

    public ImagePanel(Image image) {
        this.image = image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, this);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        if (image == null) {
            return super.getPreferredSize();
        } else {
            int w = image.getWidth(this);   
            int h = image.getHeight(this);
            return new Dimension(w, h);
        }
    }
}