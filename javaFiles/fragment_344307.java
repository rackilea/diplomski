PDFont font = PDType1Font.COURIER_OBLIQUE;
    PDDocument originalDoc = PDDocument.load(new File("...inputfile.pdf"));
    PDPage page1 = originalDoc.getPage(0);
    PDPageContentStream contentStream = new PDPageContentStream(originalDoc, page1, true, true, true);
    contentStream.setFont(font, 50);
    contentStream.setNonStrokingColor(0);
    contentStream.beginText();
    contentStream.moveTextPositionByAmount(200, 200);
    contentStream.drawString("deprecated");  // deprecated. Use showText(String text)
    contentStream.endText();
    contentStream.close();
    originalDoc.save("....result2.pdf");
    originalDoc.close();