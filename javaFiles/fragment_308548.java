public StartScreenPlayerPanel() 
{
    setLayout(new BorderLayout());

    table = new JTable();
    table.setModel( ... );

    add(table.getTableHeader(), BorderLayout.NORTH);
    add(table, BorderLayout.CENTER);
}