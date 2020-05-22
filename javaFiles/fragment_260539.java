BufferedImage img = ImageIO.read(/* from somewhere */);

if (img.getColorModel().hasAlpha()) {
    // img has alpha channel
} else {
    // no alpha channel
}