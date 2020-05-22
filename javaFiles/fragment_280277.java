public class RoadMap extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g.create();
        g2.translate(getWidth() / 2, getHeight() / 2);

        g2.setColor(Color.blue);

        for(int i = 0; i < Graph.getEdges().length; i++) {   
            Shape s = new Line2D.Double(
                Graph.vMap.get(Graph.getEdges()[i].i1).x,
                Graph.vMap.get(Graph.getEdges()[i].i1).y,
                Graph.vMap.get(Graph.getEdges()[i].i2).x,
                Graph.vMap.get(Graph.getEdges()[i].i2).y);

            g2.draw(s);
        }

        g2.dispose();
    }
}