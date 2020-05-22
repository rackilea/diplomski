private static final double CELL_DEFAULT_HEIGHT = 17;
private static final double CELL_DEFAULT_WIDTH = 64;

File imageFile = new File(GIF_OR_JPG_IMAGE_FILE);
BufferedImage input = ImageIO.read(imageFile);
ByteArrayOutputStream baos = new ByteArrayOutputStream();
ImageIO.write(input, "PNG", baos);
sheet.addImage(new WritableImage(1,1,input.getWidth() / CELL_DEFAULT_WIDTH,
    input.getHeight() / CELL_DEFAULT_HEIGHT,baos.toByteArray()));