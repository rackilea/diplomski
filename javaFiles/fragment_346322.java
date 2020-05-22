while (rowIterator.hasNext()) {    
Row row = rowIterator.next();
    List<String> recordArry = new ArrayList<String>();
    Iterator<Cell> cellIterator = row.cellIterator();
    while (cellIterator.hasNext()) {
        Cell cell = cellIterator.next();
        cell.setCellType(Cell.CELL_TYPE_STRING);
        recordArry.add(cell.getStringCellValue() + "|");
    }
    StringBuilder recordString = new StringBuilder();
    for (String elem : recordArry) {
        recordString.append(elem);
    }
    String recordString2 = StringUtils.chomp(recordString.toString(), "|");
    outfilewriter.print(recordString2);
    outfilewriter.print("\n");
}