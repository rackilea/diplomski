public void createPdf() {

    try(ByteArrayOutputStream os = new ByteArrayOutputStream()) {

        try(PdfWriter writer = new PdfWriter(os)) {
            try(PdfDocument pdf = new PdfDocument(writer)) {
                try (Document document = new Document(pdf)) {
                    PdfPage page = pdf.addNewPage();
                    PageSize ps = pdf.getDefaultPageSize();


                    Text green = new Text("This text is green. ")
                            .setFontColor(new DeviceRgb(27,255,0));

                    Paragraph p = new Paragraph("This is the text added in the rectangle.");
                    p.add(green);

                    PdfCanvas canvas = new PdfCanvas(pdf.getFirstPage());
                    Color orange = new DeviceRgb(255, 100, 20);
                    canvas.setFillColor(orange);

                    Rectangle rect = new Rectangle(1f,ps.getHeight()-101f,ps.getWidth()-1f,100f );

                    Canvas rectangleCanvas = new Canvas(canvas, pdf, rect);
                    canvas.rectangle(rect);
                    canvas.fillStroke();
                    rectangleCanvas.add(p);
                }
            }
        }
        Files.write(new File("C:\\users\\tim\\file.pdf").toPath(), os.toByteArray(), StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);

    }  catch(IOException e) {
        throw new RuntimeException(e);
    }
}