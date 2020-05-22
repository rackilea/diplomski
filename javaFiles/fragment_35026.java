public static BufferedImage getBufferedImage(Image img)
{
    if (img instanceof BufferedImage)
    {
       return (BufferedImage) img;
    }

    BufferedImage bimage = new BufferedImage(img.getWidth(null), 
                    img.getHeight(null), BufferedImage.TYPE_INT_ARGB);

    Graphics2D bGr = bimage.createGraphics();
    bGr.drawImage(img, 0, 0, null);
    bGr.dispose();

    // Return the buffered image
    return bimage;
}