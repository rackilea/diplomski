final PdfReader tocBackgroundReader = new PdfReader("toc.pdf");
Document tocDocument = new Document(tocBackgroundReader.getCropBox(1));
ByteArrayOutputStream tocBaos = new ByteArrayOutputStream();
PdfWriter tocWriter = PdfWriter.getInstance(tocDocument, tocBaos);
tocWriter.setPageEvent(new PdfPageEventHelper() {
    PdfImportedPage stationary = tocWriter.getImportedPage(tocBackgroundReader, 1);
    @Override
    public void onEndPage(PdfWriter writer, Document document)
    {
        writer.getDirectContentUnder().addTemplate(stationary, 0, 0);
    }
});
tocDocument.open();
for (TocModel tocModel : toc) {
    PdfAction action = PdfAction.gotoLocalPage("p" + tocModel.getPageNo(), false);

    Paragraph paragraph = new Paragraph();
    Chunk chunk = new Chunk(tocModel.getTitle());
    chunk.setAction(action);
    paragraph.add(chunk);
    chunk = new Chunk(new DottedLineSeparator());
    chunk.setAction(action);
    paragraph.add(chunk);
    chunk = new Chunk(String.valueOf(tocModel.getPageNo()));
    chunk.setAction(action);
    paragraph.add(chunk);
    tocDocument.add(paragraph);
}
tocDocument.close();

PdfReader tocReader = new PdfReader(tocBaos.toByteArray());
int tocPageCount = tocReader.getNumberOfPages();
copy.addDocument(tocReader);

document.close();
logger.info("Finished TOC !!!");