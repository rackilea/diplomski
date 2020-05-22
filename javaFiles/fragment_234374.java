while (rs.next())
{
   Vector row = new Vector();

    for (int i = 1; i <= columns; i++)
    {
        row.addElement( rs.getObject(i) );
    }

    model.addRow( row );
}