// This method resizes the BufferedImage to specified width and height.
// Returns an ImageIcon object.
private ImageIcon resizeImage(BufferedImage image, int width, int height) {

    // image - BufferedImage object of your file selected
    // width - Width of your JLabel
    // height - Height of yout JLabel

    // Creating a temporary Image of your desired size.
    BufferedImage tempImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    Graphics2D gr = tempImg.createGraphics();

    g.drawImage(image, 0, 0, width, height, null); // Draw the selected image on the tempImage from co-ordinates (0, 0) to (width, height) of the tempImage.
    g.dispose();  // Clear resources.

    return new ImageIcon(tempImage);
}