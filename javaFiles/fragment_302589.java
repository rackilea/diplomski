for (String value:values){
    Row newRow = sheet.creatRow(row);
    newRow.createCell(0).setCellValue(key);
    newRow.createCell(2).setCellValue(value);
    row++;
}