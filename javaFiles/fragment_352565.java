// GUI.draw
public void draw(List<Circle> circles)
{
//    drawingBoard.paintComponent(drawingBoard.getGraphics(), circles);
    drawingBoard.setCircles(circles);
    drawingBoard.repaint();
}


class CirclePainter extends JPanel
{
//    public void paintComponent(Graphics graphics, List<Circle> circles)
//    {
//        super.paintComponent(graphics);
//        for(Circle circle : circles)
//            graphics.fillOval(circle.getX(), circle.getY(), circle.getRadius() * 2, circle.getRadius() * 2);
//    }

    private List<Circle> circles;

    public void setCircles(final List<Circle> circles) {
        this.circles = circles;
    }

    @Override
    protected void paintComponent(final Graphics graphics) {
        super.paintComponent(graphics);
        for (Circle circle : circles)
            graphics.fillOval(circle.getX(), circle.getY(), circle.getRadius() * 2, circle.getRadius() * 2);
    }
}