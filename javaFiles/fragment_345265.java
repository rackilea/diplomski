public static void main(String[] args) throws IOException {
    BufferedImage barcodeImage = ImageIO.read(new File("src/barcode1.png"));
    int middle = barcodeImage.getHeight()/2;
    for (int i = 0; i < barcodeImage.getWidth(); i++) {
        System.out.println(barcodeImage.getRGB(i, middle));
    }
}