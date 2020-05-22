BufferedImage image = ...
Color fillColor = new Color(0, 0, 0); // Black

for (int y = 0; y < image.getHeight(); y++) {
    for (int x = 0; x < image.getWidth(); x++) {
        int color = image.getRGB(x, y);
        int alpha = (color >> 24) & 0xff;

        if (alpha == 255) {
            image.setRGB(x, y, fillColor.getRGB());
        }
    }
}