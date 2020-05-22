Sheet sheet = workbook.getSheetAt(0);
Iterator<Row> rowIterator = sheet.rowIterator();
Collection<String> relevantValuesFromA = new ArrayList<String>();
while (rowIterator.hasNext()) {
    Row row = rowIterator.next();
    Cell bCellOfRow = row.getCell(1);
    if ("1".equals(bCellOfRow.getStringCellValue())) {
        relevantValuesFromA.add(row.getCell(0).getStringCellValue());
    }
}

//now you can use relevantValuesFromA for your tests