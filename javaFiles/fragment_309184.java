PdfDocument document = new PdfDocument(new PdfReader(SRC));

for (int i = 1; i <= document.getNumberOfPages(); i++) {
    System.out.println("============PAGE NUMBER " + i + "=============" );
    System.out.println(PdfTextExtractor.getTextFromPage(document.getPage(i)));
}