model = DaneTableModel(some arg) {
     public boolean isCellEditable(int row, int col) {
        if(col == STATUS_COLUMN) return true ;
        return false;
     }
 }