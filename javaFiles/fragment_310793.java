public static String imageToBase64(byte[] data, String imageFormat) throws IOException {
    BufferedImage imag = ImageIO.read(new ByteArrayInputStream(data));
    BufferedImage bmpImg = new BufferedImage(imag.getWidth(), imag.getHeight(), BufferedImage.TYPE_INT_RGB);
    bmpImg.createGraphics().drawImage(imag, 0, 0, Color.WHITE, null);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(bmpImg, imageFormat, baos);
    String base64String = Base64.getEncoder().encodeToString(baos.toByteArray());
    return base64String;
}