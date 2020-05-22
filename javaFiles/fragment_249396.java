private static BufferedImage fixTransparency(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Color discordChatColor = new Color(54,57,62, 255);

        for (int xx = 0; xx < width; xx++) {
            for (int yy = 0; yy < height; yy++) {
                Color originalColor = new Color(image.getRGB(xx, yy), true);
                if (originalColor.getAlpha() == 0) {
                    image.setRGB(xx, yy, discordChatColor.getRGB());
                }
            }
        }
        return image;
    }