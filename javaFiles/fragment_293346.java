public class CustomLabel extends JLabel {

    private Color background = Color.RED;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Rectangle rect = g.getClipBounds();

        Polygon shape3 = new Polygon();
        shape3.addPoint(rect.x, rect.y + rect.height - 1);
        shape3.addPoint(rect.x + rect.width - 10, rect.y + rect.height - 1);
        shape3.addPoint(rect.x + rect.width - 1, rect.y + rect.height / 2);
        shape3.addPoint(rect.x + rect.width - 10, rect.y);
        shape3.addPoint(rect.x, rect.y);

        g.setColor(Color.LIGHT_GRAY);
        g.drawPolygon(shape3);
        g.setColor(background);
        g.fillPolygon(shape3);
    }

    @Override
    public void setBackground(Color arg0) {
        background = arg0;
    }
}