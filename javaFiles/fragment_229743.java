public class DrawingPanelVector extends JPanel {

    private List<Drawable> drawables;

    public DrawingPanelVector() {
        drawables = new ArrayList<>(25);
    }

    public void add(Drawable drawable) {
        drawables.add(drawable);
        repaint();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(600, 350);
    }

    // redefinición del método paint()
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Drawable drawable : drawables) {
            drawable.draw(g);
        }
    }
}