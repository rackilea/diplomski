DefaultTableModel model = new DefaultTableModel(column, 0);

for (every row)
{
    Object[] row = {....};

    model.addRow( row );
}

JTable table = new JTable( model );