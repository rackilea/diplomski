private void TabelGejalaMousePressed(java.awt.event.MouseEvent evt) {                                         
    // TODO add your handling code here:
    if (evt.getClickCount() >= 2) {

        DefaultTableModel model = (DefaultTableModel) TabelAturan.getModel();
        DefaultTableModel old = (DefaultTableModel) TabelGejala.getModel();
        model.addRow(new Object[]{TabelGejala.getValueAt(TabelGejala.getSelectedRow(), 0), TabelGejala.getValueAt(TabelGejala.getSelectedRow(), 1), 0});
        old.removeRow(TabelGejala.getSelectedRow());

        TabelAturan.requestFocus();
        TabelAturan.setRowSelectionInterval(TabelAturan.getRowCount() - 1, TabelAturan.getRowCount() - 1);
        TabelAturan.editCellAt(TabelAturan.getRowCount() - 1, 2);
    }
}