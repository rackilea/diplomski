public class ImagePanel extends JPanel {
    protected void paintComponent(...) {
        ...
}

JPanel panel = new JPanel(); // default FlowLayout that respects preferred sizes
panel.add(new ImagePanel());