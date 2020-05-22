for (int m = 0; m<v9columns.size();m++) {
    // Start at row zero and shift to row 3, then increment by m++ on each iteration
    row = sheet.createRow(0+m+2);
    cell = row.createCell(3);
    cell.setCellValue(v9columns.get(m).toString());
}