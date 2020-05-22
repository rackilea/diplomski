PDDocument document = PDDocument.load(SOURCE);
for (PDPage page : document.getDocumentCatalog().getPages()) {
    PdfContentStreamEditor identity = new PdfContentStreamEditor(document, page);
    identity.processPage(page);
}
document.save(RESULT);