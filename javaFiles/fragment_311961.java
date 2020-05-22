PDPage page = doc.getPage(0);
try (PDPageContentStream cs = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.PREPEND, true))
{
    cs.saveGraphicsState();
    cs.transform(Matrix.getScaleInstance(1, -1));
    cs.transform(Matrix.getTranslateInstance(0, -page.getCropBox().getHeight()));
    cs.saveGraphicsState();
}
try (PDPageContentStream cs = new PDPageContentStream(doc, page, PDPageContentStream.AppendMode.APPEND, true))
{
    cs.restoreGraphicsState();
    cs.restoreGraphicsState();
}