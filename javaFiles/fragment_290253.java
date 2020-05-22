ByteArrayOutputStream baos = new ByteArrayOutputStream();
try {
    ImageIO.write(image, "png", baos);
} catch (IOException e) {
    e.printStackTrace();
}
String imageString = "data:image/png;base64," +
    DatatypeConverter.printBase64Binary(baos.toByteArray());