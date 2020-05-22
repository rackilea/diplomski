PdfReader reader = new PdfReader(SOURCE);
for (int page = from; page <= to; page++)
{
    PdfReaderContentParser parser = new PdfReaderContentParser(reader);
    RenderListener renderListener = YOUR_RENDER_LISTENER_IMPLEMENTATION;
    parser.processContent(page, renderListener);
    // after the page has been processed, probably 
    // some render listener related post-processing
}