super.paintComponent(g);

Graphics2D g2d = (Graphics2D)g;

for (ShapeInfo info : shapes)
{
    g2d.setColor( info.getColor() );
    g2d.draw( info.getShape() );
}