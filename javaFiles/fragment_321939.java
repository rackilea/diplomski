static void cropPdf(PdfReader reader) throws IOException
{
    int n = reader.getNumberOfPages();
    for (int i = 1; i <= n; i++)
    {
        PdfReaderContentParser parser = new PdfReaderContentParser(reader);
        MarginFinder finder = parser.processContent(i, new MarginFinder());
        Rectangle rect = new Rectangle(finder.getLlx(), finder.getLly(), finder.getUrx(), finder.getUry());

        PdfDictionary page = reader.getPageN(i);
        page.put(PdfName.MEDIABOX, new PdfArray(new float[]{rect.getLeft(), rect.getBottom(), rect.getRight(), rect.getTop()}));
    }
}