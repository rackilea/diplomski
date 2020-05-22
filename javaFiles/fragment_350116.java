for (int i = 0; i < 6; i++) {
    if (data[i] == null || data[i].equals("")) {
        continue; // Skip if data is unusable
    }

    final Row newRow = sheet.createRow(++rowCount); // Row indices are 0-based!
    final Cell cell = newRow.createCell(aColumnNumber); // Also column indices are 0-based!

    cell.setCellValue(data[i]);
}