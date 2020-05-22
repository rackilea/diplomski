@Override
    public boolean canImport(TransferSupport supp) {
        DropLocation location = supp.getDropLocation();
        if(location instanceof javax.swing.JTable.DropLocation && shouldPaint) {
            javax.swing.JTable.DropLocation tableLocation = (javax.swing.JTable.DropLocation) location;
            int rowToInsert = tableLocation.getRow();
            //paint somehow the "green line"
            //remember that canImport is invoked when you move your mouse
        }
        return true;
    }