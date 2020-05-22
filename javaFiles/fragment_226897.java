// have method accept the image path and 
// have it throw an exception if the path is bad
private Image createImageWithText2(String resourcePath) throws IOException {

    // create one and only one BufferedImage object. 
    // If this fails, the exception will bubble up the call chain
    BufferedImage bufferedImage = ImageIO.read(getClass().getResource(resourcePath));

    // get the Graphics context for this single BufferedImage object 
    Graphics g = bufferedImage.getGraphics();  

    g.drawString("Point is here", 20, 20);

    g.dispose();  // get rid of the Graphics context to save resources

    return bufferedImage;
}