// main JPanel
@SuppressWarnings("serial")
class DeMainPanel extends JPanel {
    private BufferedImage img; // background image

    // JButton action that shows the JDialog and darkens the glasspane
    private PauseAction pauseAction = new PauseAction("Pause");

    public DeMainPanel(BufferedImage img) {
        super();
        this.img = img;
        add(new JButton(pauseAction));
    }

    // draw the "game" background image within the JPanel if not null
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }

    // size this JPanel to match the image's size
    @Override
    public Dimension getPreferredSize() {
        if (isPreferredSizeSet() || img == null) {
            return super.getPreferredSize();
        }
        int width = img.getWidth();
        int height = img.getHeight();
        return new Dimension(width, height);
    }
}