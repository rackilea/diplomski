for (int i = 0; i < sheet.getNumMergedRegions(); i++)
{
    CellRangeAddress mergedRegion = sheet.getMergedRegion(i);
    // Just add it to the sheet on the new workbook.
    mySheet.addMergedRegion(mergedRegion);
}