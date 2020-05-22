private static JTable makeSampleTable()
  {
    String[] columnNames = {"String", "Integer", "Boolean", "Double"};
    Object[][] data = {{"AAA", 12, true, 111111111111.15},
                       {"BBB", 1, false, 11199999111.15}, {"CCC", 2, true, 1155555511111.15},};
    DefaultTableModel m = new DefaultTableModel(data, columnNames)
    {

      private static final long serialVersionUID = 1L;

      @Override
      public Class<?> getColumnClass( int column )
      {
        return getValueAt(0, column).getClass();
      }
    };
    JTable table = new JTable(m);
    TableColumnModel tm = table.getColumnModel();
    tm.getColumn(3).setCellRenderer(new Double2DecimalRenderer());
    table.setDefaultEditor(Double.class, new DefaultCellEditor(new JTextField())
    {
      public Component getTableCellEditorComponent( JTable table, Object value,
                                                    boolean isSelected,
                                                    int row, int column )
      {
        NumberFormat nf;
        nf = NumberFormat.getNumberInstance();
        nf.setMinimumFractionDigits(2);
        nf.setMaximumFractionDigits(2);
        if ( ( value != null ) && ( value instanceof Number ) )
          {
          Number numberValue = (Number) value;
          delegate.setValue(nf.format(numberValue.doubleValue()));
          }
        else
          {
          delegate.setValue(value);
          }
        return editorComponent;
      }
    });
    return table;
  }