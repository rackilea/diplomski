// Create List containing Shapes to be painted

List<Shape> shapes = new ArrayList<Shape>();
shapes.add( circle ):
shapes.add( rectangle );

// The custom painting code might look like:

protected void paintComponent(Graphics g)
{
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D)g.create();

    for (Shape info : shapes)
    {
        g2d.fill( info.getShape() );
    }

    g2d.dispose();
}