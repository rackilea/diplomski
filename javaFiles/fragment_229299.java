// Imports and other stuff...

// Parameter flocation: resource location
private BufferedImage preloadImage(String flocation){
    BufferedImage bufimg = null;
    System.out.println("Attempting to load image: '" + flocation + "'");

    try {
        bufimg = ImageIO.read(this.getClass().getResourceAsStream(flocation));
    } catch(IOException e){
        System.err.println(
                "An error occurred while attempting to load '" + flocation + "'");

        return null;
    }

    // Now store this somewhere safe!
    return bufimg;
}