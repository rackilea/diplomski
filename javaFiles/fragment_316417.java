for (int x = 0; x < size; x++) {
        int red = myReadByte(dis);
        int green = myReadByte(dis);
        int blue = myReadByte(dis);
        int rgb = (0xFF << 24) | ((red & 0xFF) << 16) | ((green & 0xFF) << 8) | (blue & 0xFF);
        image.setRGB(x, y, rgb);