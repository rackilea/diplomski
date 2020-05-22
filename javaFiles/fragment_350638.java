private static BufferedImage loadImage(String filename) {
    try (InputStream in = Resources.class.getResourceAsStream("/resources/" + filename)) {
        if (in == null) throw new IOException("Resource not found");
        return ImageIO.read(in);
    } catch (IOException e) {
        System.out.println("Error while reading: " + filename);
        e.printStackTrace();
        return null;
    }
}