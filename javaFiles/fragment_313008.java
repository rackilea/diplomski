PdfReader reader1 = new PdfReader(file1);
PdfReader reader2 = new PdfReader(file2);
Document document = new Document();
FileOutputStream fos = new FileOutputStream();
PdfCopy copy = new PdfCopy(document, fs);
document.open();
PdfImportedPage page;
PdfCopy.PageStamp stamp;
Phrase phrase;
BaseFont bf = BaseFont.createFont();
Font font = new Font(bf, 9);
int n = reader1.getNumberOfPages();
for (int i = 1; i <= reader1.getNumberOfPages(); i++) {
    page = copy.getImportedPage(reader1, i);
    stamp = copy.createPageStamp(page);
    phrase = new Phrase("page " + i, font);
    ColumnText.showTextAligned(stamp.getOverContent(), Element.ALIGN_CENTER, phrase, 520, 5, 0);
    stamp.alterContents();
    copy.addPage(page);
}
for (int i = 1; i <= reader2.getNumberOfPages(); i++) {
    page = copy.getImportedPage(reader2, i);
    stamp = copy.createPageStamp(page);
    phrase = new Phrase("page " + (n + i), font);
    ColumnText.showTextAligned(stamp.getOverContent(), Element.ALIGN_CENTER, phrase, 520, 5, 0);
    stamp.alterContents();
    copy.addPage(page);
}
document.close();
reader1.close();
reader2.close();