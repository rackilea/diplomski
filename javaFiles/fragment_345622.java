void placeImage(PDDocument document, PDPage page, PDImageXObject image, float bbLowerLeftX, float bbLowerLeftY, float width, float height, float angle) throws IOException {
    try (   PDPageContentStream contentStream = new PDPageContentStream(document, page, AppendMode.APPEND, true, true)   ) {
        float bbWidth = (float)(Math.abs(Math.sin(angle))*height + Math.abs(Math.cos(angle))*width);
        float bbHeight = (float)(Math.abs(Math.sin(angle))*width + Math.abs(Math.cos(angle))*height);
        contentStream.transform(Matrix.getTranslateInstance((bbLowerLeftX + .5f*bbWidth), (bbLowerLeftY + .5f*bbHeight)));
        contentStream.transform(Matrix.getRotateInstance(angle, 0, 0));
        contentStream.drawImage(image, -.5f*width, -.5f*height, width, height);
    }
}