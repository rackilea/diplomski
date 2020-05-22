private static BufferedImage readBufferedImage (String imagePath) {
    try {
        InputStream is = IconManager.class.getClassLoader().getResourceAsStream(imagePath);
        BufferedImage bimage = ImageIO.read(is);
        is.close();
        return bimage;
    } catch (Exception e) {
        return null;
    }
}