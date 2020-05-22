PdfDocument pdf = new PdfDocument(new PdfWriter(out));

    PdfPage page = pdf.addNewPage();
    PdfCanvas pdfCanvas = new PdfCanvas(page);

    Rectangle rectangle = new Rectangle(100, 100, 100, 100);

    Canvas canvas = new Canvas(pdfCanvas, pdf, rectangle);
    canvas.add(new Paragraph("Hello World"));

    canvas.close();

    pdf.close();