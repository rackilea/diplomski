// ...
while (rowIterator.hasNext()) {
    Row row = rowIterator.next();
    Cell keyCell = row.getCell(1);
    Cell valCell = row.getCell(2);

    String key = getStringCellValue(keyCell);
    switch (cell.getCellType()) {
        case Cell.CELL_TYPE_NUMERIC:
            value = getNumericCellValue(valCell);
            break;
        case Cell.CELL_TYPE_STRING:
            value = getStringCellValue(valCell);
            break;
        }
    }

    // this line only compiles since Java 8
    result.computeIfAbsent(key, k -> new HashSet<Object>()).add(value);
}