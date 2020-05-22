static float[][] ArrayFromBImage(BufferedImage bimage, int width, int height) {
    int max_x = bimage.getWidth();
    int max_y = bimage.getHeight();
    float[][] array = new float[width][height];
    for (int x = 0; x < width; x++) {
        for (int y = 0; y < height; y++) {
            float red, alpha, value;
            int color;
            if (x >= max_x || y >= max_y) {
                array[y][x] = 0;
            } else {
                color = bimage.getRGB(x, y);
                alpha = (color >> 24) & 0xFF;
                red = (color >> 16) & 0xFF;
                value = 1f - red / 255;
                if (alpha == 0) {
                    array[y][x] = 0;
                } else {
                    array[y][x] = value;
                }
            }
        }
    }
    return array;
    }