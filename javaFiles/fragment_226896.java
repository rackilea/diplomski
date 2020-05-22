// BufferedImage Object ONE
    BufferedImage bufferedImage = new BufferedImage(1280, 800, BufferedImage.TYPE_INT_RGB); 
    Graphics g = bufferedImage.getGraphics();  // Graphics for the first object only

    try {
        // BufferedImage object TWO
        bufferedImage = ImageIO.read(getClass().getResource("Unknown.jpg"));

    } catch (IOException e) {
        e.printStackTrace();
    }

    // draw with the graphics context for the first object
    g.drawString("Point is here", 20, 20);

    return bufferedImage; // but return the second