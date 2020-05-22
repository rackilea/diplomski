Image image = customer.getImage();

BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
ByteArrayOutputStream byteArrayInputStream = new ByteArrayOutputStream();
try {
    ImageIO.write(bufferedImage, "jpeg", byteArrayInputStream);
} catch (IOException e) {
    e.printStackTrace();
}
byte[] buffer = byteArrayInputStream.toByteArray();