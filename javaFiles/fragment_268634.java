CellStyle cellStyle = workbook.createCellStyle();
Font font = workbook.createFont();
font.setFontHeight(14.0);
//some additional font configuration
cellStyle.setFont(font);
//For each cell:
    cell.setStyle(cellStyle)