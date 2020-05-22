table.setDefaultEditor(Double.class, new DefaultCellEditor(new JTextField())
    {
      public Component getTableCellEditorComponent( JTable table, Object value,
                                                    boolean isSelected,
                                                    int row, int column )
      {
        String formattedvalue = formatyourvalue(value);
        delegate.setValue(formattedvalue);
        return editorComponent;
      }
    });