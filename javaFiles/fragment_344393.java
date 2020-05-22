public class MyTableCellRenderer implements TableCellRenderer
{
    private JButton button = new JButton("Press Me");
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        return button;
    }
}

public class MyTableCellEditor extends AbstractCellEditor implements TableCellEditor
{
    private JButton button;

    public MyTableCellEditor()
    {
        button = new JButton("Press Me");
        button.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                System.out.println("buttonPressed");
            }
        });
    }
    public Object getCellEditorValue() {
        return null;
    }
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return button;
    }
}