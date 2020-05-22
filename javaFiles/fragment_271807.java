Vector<Object> columnNames = new Vector<Object>();
    Vector<Object> data = new Vector<Object>();

    //  Read data from a table

    String sql = "Select * from ???";
    Statement stmt = connection.createStatement();
    ResultSet rs = stmt.executeQuery( sql );
    ResultSetMetaData md = rs.getMetaData();
    int columns = md.getColumnCount();

    //  Get column names

    for (int i = 1; i <= columns; i++)
    {
        columnNames.addElement( md.getColumnName(i) );
    }

    //  Get row data

    while (rs.next())
    {
        Vector<Object> row = new Vector<Object>(columns);

        for (int i = 1; i <= columns; i++)
        {
            row.addElement( rs.getObject(i) );
        }

        data.addElement( row );
    }

    rs.close();
    stmt.close();
    connection.close();
}
catch(Exception e)
{
    System.out.println( e );
}