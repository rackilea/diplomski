jbRemoveRow.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        JTable table = (JTable)SwingUtilities.getAncestorOfClass(
            JTable.class, (Component) e.getSource());
        int row = table.getEditingRow();
        table.getCellEditor().stopCellEditing();
        ((PSRBTableModel)table.getModel()).removeRow(row);
        // table.updateUI();
      }
    });