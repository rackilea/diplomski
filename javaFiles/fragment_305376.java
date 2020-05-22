public CellRangeAddress getMergedRegionAt(int index) {
    //safety checks
    MergedCellsTable mrt = getMergedRecords();
    if (index >=  mrt.getNumberOfMergedRegions()) {
        return null;
    }
    return mrt.get(index);
}