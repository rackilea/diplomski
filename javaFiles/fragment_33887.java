class CellPopupMenuAction implements IMouseAction {

    private final Menu menu;

    public CellPopupMenuAction(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void run(NatTable natTable, MouseEvent event) {
        int columnPosition = natTable.getColumnPositionByX(event.x);
        int rowPosition = natTable.getRowPositionByY(event.y);

        ILayerCell cell = natTable.getCellByPosition(columnPosition, rowPosition);

        if (!cell.getDisplayMode().equals(DisplayMode.SELECT)) {
            natTable.doCommand(
                    new SelectCellCommand(
                            natTable,
                            columnPosition,
                            rowPosition,
                            false,
                            false));
        }

        menu.setData(MenuItemProviders.NAT_EVENT_DATA_KEY, event.data);
        menu.setVisible(true);
    }
}