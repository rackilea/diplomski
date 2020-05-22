public static class MyTableModel extends AbstractTableModel
{
    private List<String> columnNames = new ArrayList();
    private List<List> data = new ArrayList();

    {
        columnNames.add("First Name");
        columnNames.add("Last Name");
        columnNames.add("Sport");
        columnNames.add("# of Years");
        columnNames.add("Vegetarian");
    }

    public void addRow(List rowData)
    {
        data.add(rowData);
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }

    public int getColumnCount()
    {
        return columnNames.size();
    }

    public int getRowCount()
    {
        return data.size();
    }

    public String getColumnName(int col)
    {
        try
        {
            return columnNames.get(col);
        }
        catch(Exception e)
        {
            return null;
        }
    }

    public Object getValueAt(int row, int col)
    {
        return data.get(row).get(col);
    }

    public boolean isCellEditable(int row, int col)
    {
        return false;
    }

    public Class getColumnClass(int c)
    {
        return getValueAt(0, c).getClass();
    }
};

public static void main(String[] args)
{
    MyTableModel model = new MyTableModel();

    model.addRow(Arrays.asList("yi", "chen", "sleep", 35, true));

    JTable table = new JTable(model);
    table.setPreferredScrollableViewportSize(new Dimension(500, 70));
    table.setFillsViewportHeight(true);

    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setBounds(5, 218, 884, 194);
    //now adding this to the frame where I want to show 
    JFrame frame = new JFrame();
    frame.add(scrollPane);
    frame.setVisible(true);
}