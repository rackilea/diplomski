PdfDocument pdfDoc = new PdfDocument(new PdfWriter(outFileName));
    Document doc = new Document(pdfDoc);

    Table table = new Table(new float[]{50, 50})
            .addCell(new Cell().add(new Paragraph("cell 1, 1")))
            .addCell(new Cell().add(new Paragraph("cell 1, 2")));
    doc.add(table);
    doc.close();