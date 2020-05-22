XSSFCell cell = worksheet.getRow(rowIndex).getCell(0);
String contents = cell.getStringCellValue();

String[] items = contents.split(",");

for (String item : items) {
    System.out.println("Found csv item: " + item);
}