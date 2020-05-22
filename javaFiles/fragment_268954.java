public class DrawableRectangle extends DrawableShape
{
    @Override
    public void draw(Graphics g)
    {
        g.setColor( color );

        if (filled)
            g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        else
            g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
    }
}