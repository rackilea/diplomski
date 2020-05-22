public enum BufferedImageLoader {
    INSTANCE;
    private Map<String, BufferedImage> cache = new HashMap<>();
    public Image loadImage(String path) {
        BufferedImage image = cache.get(path);
        if (image == null) {
            try {
                image = ImageIO.read(this.getClass().getResource(path));
                cache.put(path, image);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return image;
    }
}