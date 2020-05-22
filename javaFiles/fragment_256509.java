Image image = ...
BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);

ByteArrayOutputStream bos = new ByteArrayOutputStream();
try {
    ImageIO.write(bImage, "png", bos);
} catch (IOException ex) {
    throw new IllegalStateException(ex);
}
workbook.addPicture(bos.toByteArray(), Workbook.PICTURE_TYPE_PNG);