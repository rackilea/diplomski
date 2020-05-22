// get image from imageicon
Image image = icon.getImage();

// cast it to bufferedimage
BufferedImage buffered = (BufferedImage) image;

try {
    // save to file
    File outputfile = new File("saved.png");
    ImageIO.write(buffered, "png", outputfile);
} catch (IOException e) {
    e.printStackTrace();
}