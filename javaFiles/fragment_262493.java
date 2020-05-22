private void createPdfBoxDoc() throws IOException, FileNotFoundException, COSVisitorException {
    PDDocument document = new PDDocument();
    PDPage page = new PDPage();
    document.addPage(page);
    PDPageContentStream contentStream = new PDPageContentStream(document, page);

    PDFont font = PDTrueTypeFont.loadTTF(document, "fonts/arialuni.ttf");
    contentStream.setFont(font, 12);
    contentStream.beginText();
    contentStream.moveTextPositionByAmount(100, 400);
    contentStream.drawString("š");
    contentStream.endText();
    contentStream.close();
    document.save("test.pdf");
    document.close();
}