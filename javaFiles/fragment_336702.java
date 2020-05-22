Workbook workbook = WorkbookFactory.create(new File(pathConfig1));
// Iterator<Sheet> sheetIterator = workbook.sheetIterator();
Sheet sheet = workbook.getSheetAt(0);
// Iterator<Row> rowIterator = sheet.rowIterator(); 
int nbLine = sheet.getLastRowNum() + 1;
int nbCol = sheet.getRow(0).getLastCellNum();
String[][] data = new String[nbLine][nbCol];
for (int i = 0; i < nbLine; i++) {
    Row row = sheet.getRow(i);
    for (int j = 0; j < nbCol; j++) {
        Cell cell = row.getCell(j);
        data[i][j] = cell.toString();
    }
}
// Display
for (int i = 0; i < nbLine; i++) {
    StringBuffer buff = new StringBuffer();
    int j = 0;
    for (; j < nbCol - 1; j++) {
        buff.append(data[i][j]);
        buff.append(",");
    }
    buff.append(data[i][j]);
    System.out.println(buff.toString());
}