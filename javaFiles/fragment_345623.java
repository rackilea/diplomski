PDPage page = ...;

PDRectangle mediaBox = page.getMediaBox();
float bbLowerLeftX = 50;
float bbLowerLeftY = 100;

try (   PDPageContentStream contentStream = new PDPageContentStream(document, page)   ) {
    contentStream.moveTo(bbLowerLeftX, mediaBox.getLowerLeftY());
    contentStream.lineTo(bbLowerLeftX, mediaBox.getUpperRightY());
    contentStream.moveTo(mediaBox.getLowerLeftX(), bbLowerLeftY);
    contentStream.lineTo(mediaBox.getUpperRightX(), bbLowerLeftY);
    contentStream.stroke();
}

PDImageXObject image = PDImageXObject.createFromByteArray(document, IOUtils.toByteArray(resource), "Image");
placeImage(document, page, image, bbLowerLeftX, bbLowerLeftY, image.getWidth(), image.getHeight(), (float)(Math.PI/4));
placeImage(document, page, image, bbLowerLeftX, bbLowerLeftY, .5f*image.getWidth(), .5f*image.getHeight(), 0);
placeImage(document, page, image, bbLowerLeftX, bbLowerLeftY, .25f*image.getWidth(), .25f*image.getHeight(), (float)(9*Math.PI/8));