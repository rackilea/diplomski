List<Map<String, String>> content = new ArrayList<Map<String, String>>();
for (int r = headerRowNum + 1; r <= sheet.getLastRowNum(); r++) {
    row = sheet.getRow(r);
    if (row == null)
        row = sheet.createRow(r);
    Map<String, String> valuesToHeaders = new HashMap<String, String>();
    for (Map.Entry<Integer, String> entry : colHeaders.entrySet()) {
        int colIdx = entry.getKey();
        Cell cell = row.getCell(colIdx);
        if (cell == null)
            cell = row.createCell(colIdx);
        String cellValue = formatter.formatCellValue(cell, evaluator);
        valuesToHeaders.put(entry.getValue(), cellValue);
    }
    content.add(valuesToHeaders);
}