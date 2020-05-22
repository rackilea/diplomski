static int stencilBits = 0;
public static void createDisplay() throws LWJGLException
{
    ImageIO.setUseCache(false); //Disable on-disc stream cache should speed up texture pack reloading.
    PixelFormat format = new PixelFormat().withDepthBits(24);
    try
    {
        //TODO: Figure out how to determine the max bits.
        Display.create(format.withStencilBits(8));
        stencilBits = 8;
    }
    catch(LWJGLException e)
    {
        Display.create(format);
        stencilBits = 0;
    }
}