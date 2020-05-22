private static void addTextToPage(PDDocument doc) throws IOException {
    List pages = doc.getDocumentCatalog().getAllPages();
    PDPage firstPage = (PDPage) pages.get(0);
    PDPageContentStream contentStream = new PDPageContentStream(doc, firstPage, true, true);

    firstPage.getResources().getFonts(); // <<<<<<

    contentStream.setFont(PDType1Font.HELVETICA_BOLD, 24);
    contentStream.beginText();
    contentStream.setNonStrokingColor(Color.BLACK);
    contentStream.moveTextPositionByAmount(100, 200);
    contentStream.drawString("HELLO RICHARD!!");
    contentStream.endText();
    contentStream.close();
}