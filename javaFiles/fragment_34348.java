public void createPdf(String dest) throws IOException, FileNotFoundException{
    PdfWriter writer = new PdfWriter(dest);
    PdfDocument pdfDoc = new PdfDocument(writer);

    //Turn off immediate flush to be certain the page you want to insert the table on hasn't been flushed yet
    Document doc = new Document(pdfDoc, pdfDoc.getDefaultPageSize(),false);

    //Add a some empty pages
    for (int i = 1; i < nrOfPages ; i++) {
        doc.add(new AreaBreak(AreaBreakType.NEXT_PAGE));
    }

    //Method 1: Fixed Pos table
    Table fixedPagefixedPosTable = createTable();
    float margin = 10;
    PageSize defaultSize = pdfDoc.getDefaultPageSize();
    float ypos = defaultSize.getHeight()/2;
    fixedPagefixedPosTable.setFixedPosition(tablePage,margin,ypos,defaultSize.getWidth()-2*margin);
    doc.add(fixedPagefixedPosTable);

    //Method 2: Using a canvas
    Table canvasTable = createTable();
    PdfCanvas pdfCanvas = new PdfCanvas(pdfDoc.getPage(tablePage+1));
    margin = 10;
    Rectangle canvasArea = new Rectangle(margin,margin,defaultSize.getWidth()-margin,defaultSize.getHeight()-margin);
    Canvas canvas = new Canvas(pdfCanvas,pdfDoc,canvasArea);
    canvas.add(canvasTable);
    canvas.close();

    doc.close();
}

private Table createTable(){
    //Create table
    float[] colWidths = {20f,20f,20f};
    Table table = new Table(colWidths);
    for (int j = 0; j < colWidths.length*nrOfRows; j++) {
        Cell c = new Cell();
        if(j/colWidths.length == 0){
            //Header
            c.add("Header  " +j);
        }else{
            //Data
            c.add("Data " + j/colWidths.length + ","+ j%colWidths.length);
        }
        table.addCell(c);
    }
    return table;
}