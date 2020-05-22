try {
    BufferedImage myPicture  = ImageIO.read(new File("42.png"));
    // do stuff with myPicture  here
} catch (IOException e) {
    // Handle the exaption here
    e.printStackTrace();
}