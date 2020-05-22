public void paint(Graphics g){  
    super.paint(g);
    Graphics2D g2d = (Graphics2D)g;
    for (Object o : world) {
        if (o instanceof Shape) {
            Shape shape = (Shape)o;
            //if the shape isn't created with 
            // a location, you can translate them
            shape.translate(...,...);
            g2d.setColor(....);
            g2d.draw(shape);
            //g2d.fill(...);
        }
    }
}