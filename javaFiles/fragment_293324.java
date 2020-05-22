String[][] excelData = new String[numColumns][searcsheet.getLastRowNum()];
//numColumns is the number of columns in the excel sheet.
for (int i = 0; i < rowCount + 1; i++) {
    Row row = searcsheet.getRow(i);

    for (int j = 0; j < row.getLastCellNum(); j++) {
        String data = (row.getCell(j).getStringCellValue()+ "");
        excelData[j][i] = data;
    }
}