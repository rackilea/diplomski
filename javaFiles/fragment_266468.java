while(rs.next())
    {
        Vector<Object> row = new Vector<Object>();

        for(int j=1;j<columns;j++)
        {
            rows.addElement(rs.getString(j));
        }

        model.addRow(row);
    }