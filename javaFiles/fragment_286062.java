public static void imageUpdated(BufferedImage image) {
    setImage(image);

    File outputfile = new File("savedingui.jpg");
    try {
        ImageIO.write(image, "jpg", outputfile);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void setImage(BufferedImage image) {
    File outputfile = new File("savedorig.jpg");
    try {
        ImageIO.write(image, "jpg", outputfile);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public static void main(String[] args) throws IOException {
    BufferedImage image = ImageIO.read(new File("test.jpg"));
    imageUpdated(image);
}