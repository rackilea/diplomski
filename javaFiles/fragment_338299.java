PdfDocument pdfDocument = new PdfDocument(new PdfWriter(getOutputFile()));
Document layoutDocument = new Document(pdfDocument);

// build table
Table table = new Table(UnitValue.createPercentArray(new float[]{0.5f, 0.5f}));

// add "Tax" header
Cell headerCell = new Cell(1,2);      // rowspan = 1, colspan = 2
headerCell.add(new Paragraph("Tax"));
table.addCell(headerCell);

// add "Name" and "%" header
table.addCell(new Cell().add(new Paragraph("Name")));
table.addCell(new Cell().add(new Paragraph("%")));

// add arbitrary data
table.addCell(new Cell().add(new Paragraph("The java cookbook")));
table.addCell(new Cell().add(new Paragraph("6")));

layoutDocument.add(table);
layoutDocument.close();