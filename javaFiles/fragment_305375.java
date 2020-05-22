/**
 * @return the merged region at the specified index
 */
public CellRangeAddress getMergedRegion(int index) {
    return _sheet.getMergedRegionAt(index);
}