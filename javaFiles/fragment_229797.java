public static BufferedImage resizeImage(BufferedImage inputImage, int newHeight, int newWidth){
    BufferedImage outputImage = new BufferedImage(newWidth, newHeight, inputImage.getType());
    Graphics2D graphics = outputImage.createGraphics();
    graphics.drawImage(inputImage, 0, 0, newWidth, newHeight, null);
    graphics.dispose(); 
    outputImage.flush();
    return outputImage;
}