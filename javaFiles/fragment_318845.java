private final class DrawRenderedImage implements PrivilegedAction
{
    private Graphics2D graphics2D = null;

    public DrawRenderedImage(Graphics2D graphics)
    {
        graphics2D = graphics;
        // TODO Auto-generated constructor stub
    }

    public Object run()
    {

            graphics2D.drawRenderedImage(image, new AffineTransform());


        return new Boolean(true);
    }
}