public abstract class DrawableShape
{
    protected Rectangle rectangle;
    protected Color color;
    protected boolean filled;

    public DrawableShape(Rectangle rectangle, Color color, boolean filled)
    {
        this.rectangle = rectangle;
        this.color = color;
        this.filled = filled;
    }

    abstract void draw(Graphics g);
}