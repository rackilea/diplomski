public void printThis(String localPath) {
    try {
        InputStream in = getClass().getResourceAsStream(localPath);
        BufferedImage image = ImageIO.read(in);
        printImage(image);
    } catch (Exception exc) {
        exc.printStackTrace();
        // handle elegantly...
    }
}