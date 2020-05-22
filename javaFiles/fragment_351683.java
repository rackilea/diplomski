PdfReader reader = new PdfReader(filename);
PdfReaderContentParser parser = new PdfReaderContentParser(reader);
MyImageRenderListener listener = new MyImageRenderListener(RESULT);
for (int i = 1; i <= reader.getNumberOfPages(); i++) {
    parser.processContent(i, listener);
}
reader.close();