PDDocument document = new PDDocument();
    PDPage page = new PDPage();
    document.addPage(page);
    PDImageXObject pdi = PDImageXObject.createFromFileByContent(screenshot ,document);
    PDPageContentStream contentStream = new PDPageContentStream(document, page);
    contentStream.drawImage(pdi,100,100);
    contentStream.close(); // do this before saving!

    document.save("C:/Users/123456/Documents/sample.pdf");
    document.close();