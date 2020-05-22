public class TranslucentLabel extends JLabel {
    public TranslucentLabel(String text) {
        super(text);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        graphics.setColor(getBackground());
        graphics.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(graphics);
    }
}