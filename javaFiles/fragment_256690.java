String[] columnNames = { "Id", "Date", ... };
DefaultTableModel model = new DefaultTableModel(columnNames, 0);

for (...)
{
    ...

    if (matched row found)
    {
        ...

        Object[] row = { val_0, val_1, ...};
        model.addRow( row );
}

JTable table = new JTable( model );
...