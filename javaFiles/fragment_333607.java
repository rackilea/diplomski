jComboBox.addActionListener(new ActionListener() {
  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getActionCommand().equals("comboBoxEdited")) {
      DefaultTableModel tableModel = (DefaultTableModel) jTable.getModel();
      tableModel.addRow(new Object[]{(jComboBox.getSelectedItem())});
    }
  }
});