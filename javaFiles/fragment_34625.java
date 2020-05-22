Workbook book = row.getSheet().getWorkbook();
CellStyle style = row.getCell(cellIndex).getCellStyle();
int fontIndex = style.getFontIndex();
Font font = book.getFontAt(fontIndex);
if (font.getBold()) {
    // if you are here, the font is bold
}