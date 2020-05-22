public class ImagePanel extends JPanel {
    private BufferedImage image;

    public ImagePanel() {
        try {
            image = ImageIO.read(getClass().getResource("/resources/image.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}