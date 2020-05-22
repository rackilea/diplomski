PdfReader reader = new PdfReader(resource);
PdfReaderContentParser parser = new PdfReaderContentParser(reader);
for (int pageNumber = 1; pageNumber <= reader.getNumberOfPages(); pageNumber++)
{
    ImageDetector imageDetector = new ImageDetector();
    parser.processContent(pageNumber, imageDetector);
    if (imageDetector.imageFound) {
        // There is at least one image rendered on page i
        // Thus, handle it as an image page
    } else {
        // There is no image rendered on page i
        // Thus, handle it as a no-image page
    }
}