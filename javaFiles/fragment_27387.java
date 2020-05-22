int columnCount = 0;

Cell cell = row.createCell(columnCount);
cell.setCellValue(rowCount);
columnCount++;

cell = row.createCell(columnCount);
cell.setCellValue((String) rs.getString(1));
columnCount++;

cell = row.createCell(columnCount);
cell.setCellValue((String) rs.getString(2));
columnCount++;

cell = row.createCell(columnCount);
cell.setCellValue((String) rs.getString(3));