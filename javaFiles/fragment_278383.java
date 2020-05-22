@UiHandler("table")
void onTableClick(ClickEvent event) {
    Cell cell = table.getCellForEvent(event);
    if (cell != null) {
        int rowIndex = cell.getRowIndex();
        int cellIndex = cell.getCellIndex();
    }
}