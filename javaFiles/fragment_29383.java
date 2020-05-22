BufferedImage img = ImageIO.read(new File("res\\BrokenFenceSwamp.gif"));

    Graphics g = img.getGraphics();
    g.drawString(img, 100, 100, "Hello World!");
    g.dispose();

    ImageIO.write(new File("res/TitledBFS.gif"));