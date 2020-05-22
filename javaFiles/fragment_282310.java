private void delete() {
    DefaultTableModel model = (DefaultTableModel) tblRooms.getModel();
    try {
        // get selected row index 
        int SelectedRowIndex = tblRooms.getSelectedRow();
        // Get out if nothing was selected but the button was.
        if (SelectedRowIndex == -1) { return; }
        int roomNumber = Integer.parseInt(model.getValueAt(SelectedRowIndex, 0).toString());
        updateRoomDataInFile("HotelRoomsData.txt", roomNumber, 7, "true");
        model.removeRow(SelectedRowIndex);
} catch (Exception ex) {
    JOptionPane.showMessageDialog(null, ex);
}