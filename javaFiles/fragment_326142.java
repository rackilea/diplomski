Document document = new Document();
PdfCopy copy = new PdfCopy(document, new FileOutputStream(RESULT));
document.open();
PdfReader reader;
int n;
for (int i = 0; i < files.length; i++) {
    reader = new PdfReader(files[i]);
    n = reader.getNumberOfPages();
    for (int page = 0; page < n; ) {
        copy.addPage(copy.getImportedPage(reader, ++page));
    }
    copy.freeReader(reader);
    reader.close();
}
document.close();