String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
  JComboBox<String> petCombo = new JComboBox<>(petStrings);
  String[] columnNames = {"name", "elem"};
  Object[][] data = {
      {"Pet 1", null},
      {"Pet 2", null}
  };

  DefaultTableModel model = new DefaultTableModel(data, columnNames);
  JTable table = new JTable(model);
  table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(petCombo));