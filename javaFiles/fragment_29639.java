// get your image as a resource
    URL resource = Game.class.getResource(RESOURCE_PATH);
    BufferedImage img = null;
    try {
        // read in using ImageIO
        img = ImageIO.read(resource);
    } catch (IOException e) {
        e.printStackTrace();
        System.exit(-1);
    }