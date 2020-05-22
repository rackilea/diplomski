public class DrawablePane extends JPanel {

    List<Drawable> itemsDrawn;

    public DrawablePane() {
        itemsDrawn = new ArrayList<>();
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        for (Drawable d : itemsDrawn) {
            d.paint(this, g2d);
        }
        g2d.dispose();
    }

    public void addDrawable(Drawable drawable) {

        itemsDrawn.add(drawable);
        repaint();

    }

    public void undo() {

        if (!itemsDrawn.isEmpty()) {

            int size = itemsDrawn.size() - 1;
            itemsDrawn.remove(size);
            repaint();

        }

    }

    public void clear() {

        itemsDrawn.clear();
        repaint();

    }

}