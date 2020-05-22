/**
 * Converts a provided ResultSet into a generic List so that the
 * ResultSet can be closed while the data persists.
 * Source: http://stackoverflow.com/a/7507225/899126
 */
public List convertResultSetToList(ResultSet rs) throws SQLException
{
    ResultSetMetaData md = rs.getMetaData();
    int columns = md.getColumnCount();
    List list = new ArrayList(50);

    while (rs.next())
    {
        HashMap row = new HashMap(columns);
        for(int i = 1; i <= columns; ++i)
        {
            row.put(md.getColumnName(i), rs.getObject(i));
        }
        list.add(row);
    }

    return list;
}

public List executeSearch(String q)
{
    List toReturn;
    openConnection();
    try {
        Statement statement = connection.createStatement();
        toReturn = this.convertResultSetToList(statement.executeQuery(q));
    }
    catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage());
        toReturn = new ArrayList();
    }
    finally {
        closeConnection();
    }

    return toReturn;
}