DataMatrix dataMatrix = new DataMatrix();
dataMatrix.setDataType(Symbol.DataType.GS1);
dataMatrix.setReaderInit();
dataMatrix.setPreferredSize(24); //144x144
dataMatrix.forceSquare(true);
dataMatrix.setContent(dataToEncode);
BufferedImage image = new BufferedImage((dataMatrix.getWidth() * magnification) + (2 * borderSize),
                    (dataMatrix.getHeight() * magnification) + (2 * borderSize), BufferedImage.TYPE_INT_RGB);
Graphics2D g2d = image.createGraphics();
g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
g2d.setColor(Color.WHITE);
g2d.fillRect(0, 0, (dataMatrix.getWidth() * magnification) + (2 * borderSize),
                    (dataMatrix.getHeight() * magnification) + (2 * borderSize));
Java2DRenderer renderer = new Java2DRenderer(g2d, magnification, borderSize, Color.WHITE, Color.BLACK);
renderer.render(dataMatrix);
try {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    ImageIO.write(image, "png", baos);
    //Before Base64-encoding the image and return as a String        
    Base64.Encoder encoder = Base64.getEncoder(); 
    return encoder.encodeToString(baos.toByteArray());
} catch (IOException e) {
//Do some logging
return "Something went wrong";//Return super-informative error message
}