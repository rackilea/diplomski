public static boolean isFullyAlpha(File f) throws IOException {
    BufferedImage img = ImageIO.read(f);
    for(int y = 0; y < img.getHeight(); y++) {
        for(int x = 0; x < img.getWidth(); x++) {
            if(((img.getRGB(x, y) >> 24) & 0xFF) != 0) {
                return false;
            }
        }
    }
    return true;
}