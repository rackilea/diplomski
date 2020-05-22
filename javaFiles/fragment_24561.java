RowHeaderTable rowTable = new RowHeaderTable(mainTable);
    rowTable.setAutoscrolls(true);
    rowTable.setDragEnabled(true);
    rowTable.setTransferHandler(new RowHeaderTransferHandler(mainTable));
    rowTable.setDropMode(DropMode.INSERT_ROWS);
    try {
        DropTarget dropTarget = rowTable.getDropTarget();
        dropTarget.addDropTargetListener(rowTable);
    }
    catch(TooManyListenersException e) {
        e.printStackTrace();
    }