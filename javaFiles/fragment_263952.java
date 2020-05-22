for (int x = 0; x < w / 2; x++) {
        for (int y = 0; y < h; y++) {
            final int l = tmp.getRGB( w - (x + 1), y);
            final int r = tmp.getRGB( x, y);
            tmp.setRGB( x, y, l );
            tmp.setRGB( w - (x + 1), y, r );
        }
    }