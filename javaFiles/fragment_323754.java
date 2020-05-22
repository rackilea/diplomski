public void actionPerformed (ActionEvent e)
{
    Dimension size = frame2.getSize ();
    BufferedImage img = new BufferedImage (size.width, size.height, BufferedImage.TYPE_3BYTE_BGR);
    Graphics g = img.getGraphics ();
    frame2.printAll (g);
    g.dispose ();
    try
    {
        ImageIO.write (img, "png", new File ("screenshot.png"));
    }
    catch (IOException ex)
    {
        ex.printStackTrace ();
    }
}