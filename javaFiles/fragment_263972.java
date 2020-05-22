public static void addColLabel(XSSFPivotTable pivotTable, int columnIndex) {
    AreaReference pivotArea = new AreaReference(pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition()
            .getCacheSource().getWorksheetSource().getRef());
    int lastRowIndex = pivotArea.getLastCell().getRow() - pivotArea.getFirstCell().getRow();
    int lastColIndex = pivotArea.getLastCell().getCol() - pivotArea.getFirstCell().getCol();

    if (columnIndex > lastColIndex) {
        throw new IndexOutOfBoundsException();
    }
    CTPivotFields pivotFields = pivotTable.getCTPivotTableDefinition().getPivotFields();

    CTPivotField pivotField = CTPivotField.Factory.newInstance();
    CTItems items = pivotField.addNewItems();

    pivotField.setAxis(STAxis.AXIS_COL);
    pivotField.setShowAll(false);
    for (int i = 0; i <= lastRowIndex; i++) {
        items.addNewItem().setT(STItemType.DEFAULT);
    }
    items.setCount(items.sizeOfItemArray());
    pivotFields.setPivotFieldArray(columnIndex, pivotField);

    CTColFields rowFields;
    if (pivotTable.getCTPivotTableDefinition().getColFields() != null) {
        rowFields = pivotTable.getCTPivotTableDefinition().getColFields();
    } else {
        rowFields = pivotTable.getCTPivotTableDefinition().addNewColFields();
    }

    rowFields.addNewField().setX(columnIndex);
    rowFields.setCount(rowFields.sizeOfFieldArray());
}