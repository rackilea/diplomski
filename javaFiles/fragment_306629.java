PDFMergerUtility finalDoc = new PDFMergerUtility(); 
for (StudentEN student : students) {
    PDDocument document = PDDocument.load("template.pdf");
    PDPage page = (PDPage) document.getDocumentCatalog().getAllPages().get(0);
    PDPageContentStream contentStream = new PDPageContentStream(document, page, true, true);

    contentStream.beginText();
    // Draw stuff
    contentStream.endText();

    contentStream.close();

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    document.save(out);
    finalDoc.addSource(new ByteArrayInputStream(out.toByteArray()));
    document.close();
}

response.setContentType("application/pdf");
finalDoc.setDestinationStream(response.getOutputStream());
finalDoc.mergeDocuments();