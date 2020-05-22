Icon normal = new ImageIcon(...);
Icon selected = new ImageIcon(...);
JTable table = new JTable(...);
table.setRowHeight(...);

TableCellRenderer renderer = table.getDefaultRenderer(Boolean.class);
JCheckBox checkBoxRenderer = (JCheckBox)renderer;
checkBoxRenderer.setIcon( normal );
checkBoxRenderer.setSelectedIcon( selected );

DefaultCellEditor editor = (DefaultCellEditor)table.getDefaultEditor(Boolean.class);
JCheckBox checkBoxEditor = (JCheckBox)editor.getComponent();
checkBoxEditor.setIcon( normal );
checkBoxEditor.setSelectedIcon( selected );