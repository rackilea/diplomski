public List<Element> createTemplate() throws Exception {
    List<Element> elementList = new ArrayList<Element>();
    float[] tableWidths = new float[]{1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f, 1.25f, 1.25f, 1.25f};
    //      logger.debug("entering create reports template...");

    PdfPTable splitTable = new PdfPTable(1);
    splitTable.setSplitRows(false);
    splitTable.setWidthPercentage(100f);

    PdfPTable pageTable = new PdfPTable(1);
    pageTable.setKeepTogether(true);
    pageTable.setWidthPercentage(100f);

    PdfPTable searchTable = generateSearchFields();
    if(searchTable != null){
        searchTable.setSpacingAfter(25f);
    }

    PdfPTable outlineTable = new PdfPTable(1);
    outlineTable.setKeepTogether(true);
    outlineTable.setWidthPercentage(100f);

    PdfPTable datatable = new PdfPTable(datatableHeaderFields.length);
    //        datatable.setKeepTogether(false);
    datatable.setWidths(tableWidths);


    generateDatatableHeader(datatable);

    for(int i = 0; i < 100; i++){
        addCell(datatable, String.valueOf(i), 1, Rectangle.NO_BORDER, Element.ALIGN_CENTER, smallFont, true);
        addCell(datatable, String.valueOf(i+1), 1, Rectangle.NO_BORDER, Element.ALIGN_CENTER, smallFont, true);
        addCell(datatable, String.valueOf(i+2), 1, Rectangle.NO_BORDER, Element.ALIGN_CENTER, smallFont, true);
        addCell(datatable, String.valueOf(i+3), 1, Rectangle.NO_BORDER, Element.ALIGN_CENTER, smallFont, true);
        addCell(datatable, String.valueOf(i+4), 1, Rectangle.NO_BORDER, Element.ALIGN_CENTER, smallFont, true);
        addCell(datatable, String.valueOf(i+5), 1, Rectangle.NO_BORDER, Element.ALIGN_CENTER, smallFont, true);
        addCell(datatable, String.valueOf(i+6), 1, Rectangle.NO_BORDER, Element.ALIGN_CENTER, smallFont, true);
        addCell(datatable, String.valueOf(i+7), 1, Rectangle.NO_BORDER, Element.ALIGN_CENTER, smallFont, true);
        addCell(datatable, String.valueOf(i+8), 1, Rectangle.NO_BORDER, Element.ALIGN_RIGHT, smallFont, true);
    }

    //        PdfPCell dataCell = new PdfPCell(datatable);
    //        dataCell.setBorder(Rectangle.BOX);
    //        outlineTable.addCell(dataCell);
    //
    //        PdfPCell searchCell = new PdfPCell(searchTable);
    //        searchCell.setVerticalAlignment(Element.ALIGN_TOP);
    //
    //        PdfPCell outlineCell = new PdfPCell(outlineTable);
    //        outlineCell.setVerticalAlignment(Element.ALIGN_TOP);
    //
    //        addCell(pageTable, searchCell, 1, Rectangle.NO_BORDER, Element.ALIGN_LEFT, null, null);
    //        addCell(pageTable, outlineCell, 1, Rectangle.NO_BORDER, Element.ALIGN_CENTER, null, null);
    //
    //        PdfPCell pageCell = new PdfPCell(pageTable);
    //        pageCell.setVerticalAlignment(Element.ALIGN_TOP);
    //        addCell(splitTable, pageCell, 1, Rectangle.NO_BORDER, Element.ALIGN_CENTER, null, null);

    elementList.add(searchTable);
    elementList.add(datatable);
    //      elementList.add(pageTable);
    //      elementList.add(splitTable);

    return elementList;
}