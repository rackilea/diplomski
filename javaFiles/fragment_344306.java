PDDocument overlayDoc = new PDDocument();
    PDPage page = new PDPage();
    overlayDoc.addPage(page);
    Overlay overlayObj = new Overlay();
    PDFont font = PDType1Font.COURIER_OBLIQUE;

    PDPageContentStream contentStream = new PDPageContentStream(overlayDoc, page);
    contentStream.setFont(font, 50);
    contentStream.setNonStrokingColor(0);
    contentStream.beginText();
    contentStream.moveTextPositionByAmount(200, 200);
    contentStream.drawString("deprecated");  // deprecated. Use showText(String text)
    contentStream.endText();
    contentStream.close();

    PDDocument originalDoc = PDDocument.load(new File("...inputfile.pdf"));
    overlayObj.setOverlayPosition(Overlay.Position.FOREGROUND);
    overlayObj.setInputPDF(originalDoc);
    overlayObj.setAllPagesOverlayPDF(overlayDoc);
    Map<Integer, String> ovmap = new HashMap<Integer, String>();
    overlayObj.setOutputFile("... result-with-overlay.pdf");
    overlayObj.overlay(ovmap);
    overlayDoc.close();
    originalDoc.close();