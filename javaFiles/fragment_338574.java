public final void constructModel(ResultSet rs) throws SQLException {
    ResultSetMetaData rsmd = rs.getMetaData();
    rs.last();
    rowCount = rs.getRow();
    int columnCount = rsmd.getColumnCount();
    // DatabaseColumn simply holds a name and a Class<?>.
    columns = new DatabaseColumn[columnCount];
    // This is the Object[][] array that you were talking about.
    // It holds all the data from the ResultSet.
    data = new Object[columnCount][rowCount];
    for (int i = 0; i < columnCount; ++i) {
        // Figure out the column name and type.
        int j = i + 1;
        String colName = rsmd.getColumnLabel(j);
        Class<?> colClass = String.class;
        try {
            colClass = Class.forName(rsmd.getColumnClassName(j));
        } catch (ClassNotFoundException ex) {
            colClass = String.class;
        }
        columns[i] = new DatabaseColumn(colName, colClass);
        // Get the data in the current column as an Object.
        rs.beforeFirst();
        for (int k = 0; rs.next(); ++k) {
            data[i][k] = rs.getObject(j);
        }
    }
    // Notify listeners about the changes so they can update themselves.
    fireTableStructureChanged();
}