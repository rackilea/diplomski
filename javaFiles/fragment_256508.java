Image image = ...
BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);

PipedOutputStream pos;
try (PipedInputStream pis = new PipedInputStream()) {
    pos = new PipedOutputStream(pis);
    new Thread(() -> {
        try {
            ImageIO.write(bImage, "png", pos);
        } catch (IOException ex) {
            throw new IllegalStateException(ex);
        }
    }).start();
    workbook.addPicture(pis, Workbook.PICTURE_TYPE_PNG);
} catch (IOException ex) {
    throw new IllegalStateException(ex);
}