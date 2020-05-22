public class ImagePanel extends JPanel {
    public ImagePanel() {
        setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(IMG_SIZE, IMG_SIZE);
    }
}