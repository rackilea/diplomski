PdfDocument pdfDoc = new PdfDocument(new PdfWriter(destinationFolder + "simpleCanvas.pdf"));

    PdfPage page1 = pdfDoc.addNewPage();

    PdfCanvas canvas = new PdfCanvas(page1);
    canvas.rectangle(100, 100, 100, 100).fill();

    pdfDoc.close();