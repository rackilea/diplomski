public class GamePanel extends JPanel {
    private Image image;

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(image.getWidth(this), image.getHeight(this));
        // or whatever you want the size to be
    }
}