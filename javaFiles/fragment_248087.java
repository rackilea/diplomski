public BufferedImage createBufImg(String filePath) {
    try {
        return ImageIO.read(new File(filePath));
    } catch (IOException e) {
        System.out.println("Could not read image");
    }
    return null;
 }