protected AffineTransform calculateAffineTransform(PDPage page, PDRectangle overlayMediaBox)
{
    AffineTransform at = new AffineTransform();
    PDRectangle pageMediaBox = page.getMediaBox();
    at.translate(0, pageMediaBox.getHeight() - overlayMediaBox.getHeight());
    return at;
}