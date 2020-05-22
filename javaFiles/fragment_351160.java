Workbook workbook = WorkbookFactory.create(new File("input.xlsx"));
DataFormatter formatter = new DataFormatter();
Sheet s = workbook.getSheetAt(0);
for (Row r : s) {
  for (Cell c : r) {
     System.out.println(formatter.formatCellValue(c));
  }
}