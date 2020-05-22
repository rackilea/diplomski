public class ButtonTableTest {

    public static void main(String[] args) {
        final Random random = new Random();
        DefaultTableModel tableModel = new DefaultTableModel(20, 7) {
            @Override
            public Class<?> getColumnClass(int arg0) {
              // provide the default renderer and editor of String for empty cells
                return String.class; 
            }

            @Override
            public boolean isCellEditable(int row, int column) {
               // do not request the editor for empty cells
                return !"".equals(getValueAt(row, column));
            }

            @Override
            public Object getValueAt(int row, int column) {
                // some random table content
                if (null == super.getValueAt(row, column)) {
                    int nextInt = random.nextInt(10);
                    if (nextInt > 5)
                        super.setValueAt(String.format("cell %dx%d", row, column), row, column);
                    else
                        super.setValueAt("", row, column);
                }
                return super.getValueAt(row, column);
            }

            @Override
            public void setValueAt(Object arg0, int arg1, int arg2) {
                // prevent update to NULL
            }

        };

        JTable jTable = new JTable(tableModel);
        jTable.setPreferredSize(new Dimension(800, 350));
        final JButton jButton = new JButton();

        jTable.setDefaultRenderer(String.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                    boolean hasFocus, int row, int column) {
                Component tableCellRendererComponent = super.getTableCellRendererComponent(table, value, isSelected,
                        hasFocus, row, column);
                if ("".equals(value)) {
                    // default renderer for empty cells
                    return tableCellRendererComponent;
                } else {
                    jButton.setAction(createSameActionForEditorAndRenderer(table, value));
                    return jButton;
                }
            }
        });
        jTable.setDefaultEditor(String.class, new DefaultCellEditor(new JCheckBox()) { // JCheckBox is closest to a button...

            @Override
            public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                    int column) {
                Component tableCellEditorComponent = super.getTableCellEditorComponent(table, value, isSelected, row,
                        column);
                jButton.setAction(createSameActionForEditorAndRenderer(jTable, value));
                return jButton;
            }

        });
        JOptionPane.showMessageDialog(null, jTable);
    }

    private static AbstractAction createSameActionForEditorAndRenderer(JTable table, Object value) {
        return new AbstractAction((String) value) {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(table, String.format("clicked on %s",value));
                });
                table.getCellEditor().stopCellEditing();
                table.repaint();
            }
        };
    }
}