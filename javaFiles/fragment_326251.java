public static BufferedImage getImage(String path) {
    BufferedImage img = null;
    try {
        img = ImageIO.read(GUI.class.getResource(path));
    } catch (IOException ex) {
        ex.printStackTrace();
    }
    return img;
}