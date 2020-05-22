CellReference[] crefs = this.getCellsByName(wb, cName);

    // Locate the cell position
    Sheet sheet = wb.getSheet(crefs[0].getSheetName());
    Row row = sheet.getRow(crefs[0].getRow());
    Cell cell = row.getCell(crefs[0].getCol());

    // Write in data
    cell.setCellValue(cellRegion.getContent());