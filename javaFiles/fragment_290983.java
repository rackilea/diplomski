DefaultTableModel model = new DefaultTableModel(columns, 0);

for(int i=0;i<itemArray.length;i++)
{
    Vector row = new Vector(3);
    row.add( itemArray[i] );
    row.add( conditionArray[i] );
    row.add( locationArray[i] );
    model.addRow( row );
}

JTable table = new JTable( model );