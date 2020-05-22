public void createPdf(String dest) throws IOException, FileNotFoundException{
    PdfWriter writer = new PdfWriter(dest);
    PdfDocument pdfDoc = new PdfDocument(writer);
    Document doc = new Document(pdfDoc);
    float tableWidth = 100f;
    //Using defaults
    doc.add(new Paragraph("default/auto-layout"));
    doc.add(new Paragraph("Using a float[]"));
    float[] colWidths = {1,2,3,4};
    Table table = new Table(colWidths);
    table.setWidthPercent(tableWidth);
    fillTable(table);
    doc.add(table);

    doc.add(new Paragraph("Using a UnitValue[] point array"));
    colWidths=new float[]{20f,40f,80f,160f};
    table = new Table(UnitValue.createPointArray(colWidths));
    table.setWidth(tableWidth);
    fillTable(table);
    doc.add(table);

    doc.add(new Paragraph("Using a UnitValue[] percent array"));
    colWidths=new float[]{1,2,3,4};
    table = new Table(UnitValue.createPercentArray(colWidths));
    table.setWidthPercent(tableWidth);
    fillTable(table);
    doc.add(table);

    doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
    //Using fixedLayout
    doc.add(new Paragraph("Using fixedLayout"));
    doc.add(new Paragraph("Using a float[]"));
    colWidths =new float[]{1,2,3,4};
    table = new Table(colWidths);
    table.setFixedLayout();
    table.setWidthPercent(tableWidth);
    fillTable(table);
    doc.add(table);

    doc.add(new Paragraph("Using a UnitValue[] point array"));
    colWidths=new float[]{20f,40f,80f,160f};
    table = new Table(UnitValue.createPointArray(colWidths));
    table.setWidthPercent(tableWidth);
    table.setFixedLayout();
    fillTable(table);
    doc.add(table);

    doc.add(new Paragraph("Using a UnitValue[] percent array"));
    colWidths=new float[]{1,2,3,4};
    table = new Table(UnitValue.createPercentArray(colWidths));
    table.setWidthPercent(tableWidth);
    table.setFixedLayout();
    fillTable(table);
    doc.add(table);

    doc.close();
}

public void fillTable(Table table){
    table.addCell("Water");
    table.addCell("Fire");
    table.addCell("Heaven");
    table.addCell("As I'm grounded here on");
    table.addCell("It's waving oceans are calling");
    table.addCell("is burning me deep inside");
    table.addCell("can wait for me");
    table.addCell("Earth");
}