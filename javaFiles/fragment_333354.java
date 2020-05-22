public BufferedImage icon32 = loadBufferedImage("/icon/icon32.png");
public BufferedImage icon64 = loadBufferedImage("/icon/icon64.png");

private BufferedImage loadBufferedImage(String string)
{
    try
    {
        BufferedImage bi = ImageIO.read(this.getClass().getResource(string));
        return bi;
    } catch (IOException e)
    {
        e.printStackTrace();
    }
    return null;
}