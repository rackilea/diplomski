public static BufferedImage rotate(BufferedImage image, float angle) 
{
    float radianAngle = (float) Math.toRadians(angle) ; 

    float sin = (float) Math.abs(Math.sin(radianAngle));
    float cos = (float) Math.abs(Math.cos(radianAngle));

    int w = image.getWidth() ;
    int h = image.getHeight();

    int neww = (int) Math.round(w * cos + h * sin);
    int newh = (int) Math.round(h * cos + w * sin);

    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice gd = ge.getDefaultScreenDevice();
    GraphicsConfiguration gc = gd.getDefaultConfiguration();

    BufferedImage result = gc.createCompatibleImage(neww, newh, Transparency.TRANSLUCENT);
    Graphics2D g = result.createGraphics();

    //-----------------------MODIFIED--------------------------------------
    g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON) ;
    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BICUBIC) ;
    g.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY) ;

    AffineTransform at = AffineTransform.getTranslateInstance((neww-w)/2, (newh-h)/2);
    at.rotate(radianAngle, w/2, h/2);
    //---------------------------------------------------------------------

    g.drawRenderedImage(image, at);
    g.dispose();

    return result;
}