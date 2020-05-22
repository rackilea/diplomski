if (isCellContentEqual(cellComparisonFile1, cellComparisonFile2) == true)
{
    CellStyle style = workbook.createCellStyle();
    style.cloneStyleFrom(cellOutputFile.getCellStyle());
    style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    cellOutputFile.setCellStyle(style);
}
else
{
    CellStyle style = workbook.createCellStyle();
    style.cloneStyleFrom(cellOutputFile.getCellStyle());
    style.setFillForegroundColor(IndexedColors.RED.getIndex());
    style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
    cellOutputFile.setCellStyle(style);
}