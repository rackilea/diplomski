BufferedImage image = loadImage(loc);
    image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels, 0, image.getWidth());

    ByteBuffer buffer = BufferUtils.createByteBuffer(image.getWidth() * image.getHeight() * 4);
    Color c;

    for (int y = 0; y < image.getHeight(); y++) {
        for (int x = 0; x < image.getWidth(); x++) {
            c = new Color(image.getRGB(x, y));
            buffer.put((byte) c.getRed());     // Red component
            buffer.put((byte) c.getGreen());      // Green component
            buffer.put((byte) c.getBlue());               // Blue component
            buffer.put((byte) c.getAlpha());    // Alpha component. Only for RGBA
        }
    }