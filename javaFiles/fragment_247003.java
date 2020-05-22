//Calculate columnIndexKey and columnIndexValue

Map<String, List<String>> result = new HashMap<>();
if (columnIndexKey != null && comumnIndexValue != null) {
    for (Row row : myExcelSheet3) {
        if (row.getRowNum() == 0) {
            continue;
        }
        Cell cell = row.getCell(columnIndexKey);
        Cell valueCell = row.getCell(columnIndexValue);

        String key = getCellData(xssfWorkbook, cell);
        String value = getCellData(xssfWorkbook, valueCell);

        if (!result.contains(key)) {
            result.put(key, new ArrayList<>());
        }
        result.get(key).add(value);
    }
}

result.foreach((k, v) -> System.out.println("Key = "+ k + ", Value = " + v));