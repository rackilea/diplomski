protected void updateImage(String name) 
{
    BufferedImage image = null;
    Image scaledImage = null;
    JLabel tempImage;

    try
    {
        image = ImageIO.read(new File(name));
    } 
    catch (IOException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    // getScaledImage returns an Image that's been resized 
    // proportionally to my thumbnail constraints
    scaledImage = getScaledImage(image, THUMB_SIZE_X, THUMB_SIZE_Y);
    tempImage = new JLabel(new ImageIcon(scaledImage));
    rightPane.remove(swingImage);
    swingImage = tempImage;
    rightPane.add(swingImage, BorderLayout.PAGE_START);
    rightPane.revalidate();
    rightPane.repaint(); // required sometimes
}