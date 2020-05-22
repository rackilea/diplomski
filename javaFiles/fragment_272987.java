for(int RowNum=0; RowNum<MaxArrayLength;RowNum++){
    HSSFRow row = sheet.createRow(RowNum);
    for(int ColNum=0; ColNum<ArrayWidth;ColNum++){
        HSSFCell cell = row.createCell(ColNum);
        cell.setCellValue(ArrayList[RowNum][ColNum]);
     }
 }