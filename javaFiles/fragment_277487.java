CellStyle combined = workbook.createCellStyle();
combined.cloneStyleFrom(colourCellStyle);
combined.setDataFormat(dateCellStyle.getDataFormat());
// You can copy other attributes to "combined" here if desired.

cell9.setCellStyle(combined);