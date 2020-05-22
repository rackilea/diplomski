...
CellStyle cellStyle = workbook.createCellStyle();
cellStyle.setFont(headerFont);
//cellStyle.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());
cellStyle.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
cellStyle.setAlignment(HorizontalAlignment.CENTER);
...