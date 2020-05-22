//Retrieve the row and check for null
HSSFRow sheetrow = sheet.getRow(row);
if(sheetrow == null){
    sheetrow = sheet.createRow(row);
}
//Update the value of cell
cell = sheetrow.getCell(col);
if(cell == null){
    cell = sheetrow.createCell(col);
}
cell.setCellValue("Pass");