private TableModel model = new DefaultTableModel(data, columnNames)
  {
    public boolean isCellEditable(int row, int column)
    {
      return false;//This causes all cells to be not editable
    }
  };
  private JTable table = new JTable(model);