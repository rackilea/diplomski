try {
    BufferedImage img = ImageIO.read(getClass().getResource("/resources/images/pieces/blank.png"));
    ImageIcon icon = new ImageIcon(img);
    // update UI
} catch (IOException exp) {
    exp.printStackTrace();
    // Probably show a message and exit...
}