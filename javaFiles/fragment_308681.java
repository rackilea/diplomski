BufferedImage img; // your original palette image

int w = img.getWidth();
int h = img.getHeight();
BufferedImage trueColor = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

Graphics2D g = trueColor.createGraphics();
try {
    g.drawImage(img, 0, 0, null);
}
finally {
    g.dispose();
}

img = trueColor;