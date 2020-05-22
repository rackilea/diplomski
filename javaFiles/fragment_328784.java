public class TranslucentTableHeader extends JTableHeader {

    public TranslucentTableHeader() {
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setColor(getBackground());
        g2d.fill(new Rectangle(0, 0, getWidth(), getHeight()));
        super.paintComponent(g2d);
        g2d.dispose();
    }


}