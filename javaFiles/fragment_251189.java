for (int i = 1; i < rowNum; i++) {
  Row row = sheet.getRow(i);
  Cell cell1 = row.getCell(0);
  Cell cell2 = row.getCell(4);
  String id = cell1.getStringCellValue();
  String city = cell2.getStringCellValue();

  if(id.equalsIgnoreCase("101") && city.equalsIgnoreCase("New York")) {
    Cell lastCellInRow = row.getCell(row.getLastCellNum() - 1);
    System.out.println(lastCellInRow.getStringCellValue());
  }
}