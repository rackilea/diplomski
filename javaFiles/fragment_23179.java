for(int row = 0; row < allength; row++){
    Row currentRow = sheet.createRow(row);
    for(int column = 0; column < 13; column++){
         Cell cell = currentRow.createCell(column);
         cell.setCellValue(arraylistCategory.get(row)[column]);
    }
}