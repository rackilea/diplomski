BufferedImage im = ImageIO.read(....);

    int width = im.getWidth();
    int height = im.getHeight();

    for (int x = 0; x < width; x++)
    {
        for (int y = 0; y < height; y++)
            System.out.println("x = " + x + ", y = " + y + ", color = " + im.getRGB(x, y));
    }