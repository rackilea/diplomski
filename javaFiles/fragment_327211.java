public class DrawPanel extends JPanel {
    private Drawable drawable;

    public DrawPanel() {}

    public DrawPanel(Drawable drawable) {
        this.drawable = drawable;
    }

    public void setDrawable(Drawable drawable) {
        this.drawable = drawable;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (drawable != null) {
            drawable.draw(g);
        }
    }
}