public void processImage(BufferedImage bimg, int brightness, int contrast, int t_black, int t_white) {
        Color c;
        int r, g, b;
        float factor = (259f * (contrast + 255f)) / (255f * (259f - contrast));

        for (int x = 0; x < bimg.getWidth(); x++)
            for (int y = 0; y < bimg.getHeight(); y++) {
                c = new Color(bimg.getRGB(x, y));
                // apply brightness and contrast
                r = Math.round(factor * (c.getRed() - 128) + 128) + brightness;
                g = Math.round(factor * (c.getGreen() - 128) + 128) + brightness;
                b = Math.round(factor * (c.getBlue() - 128) + 128) + brightness;
                // limit to [0, 255] range
                r = Math.min(255, Math.max(0, r));
                g = Math.min(255, Math.max(0, g));
                b = Math.min(255, Math.max(0, b));
                // apply black and white thresholds
                if (r < t_black && g < t_black && b < t_black)
                    bimg.setRGB(x, y, 0);
                else if (r > t_white && g > t_white && b > t_white)
                    bimg.setRGB(x, y, 255 << 16 | 255 << 8 | 255);
                else
                    bimg.setRGB(x, y, r << 16 | g << 8 | b);
            }
    }