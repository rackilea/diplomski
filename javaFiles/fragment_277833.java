try {
    // retrieve image
    BufferedImage bi = getMyImage();
    File outputfile = new File("saved.png");
    ImageIO.write(bi, "png", outputfile);
} catch (IOException e) {
    ...
}