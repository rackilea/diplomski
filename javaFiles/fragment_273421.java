byte[] imageBackground = // set me here;
ByteArrayInputStream input = new ByteArrayInputStream(imageBackground);
try {
    BufferedImage ImageIO.read(input);
    // do fun stuff with the image...
}
finally {
    input.close();
}