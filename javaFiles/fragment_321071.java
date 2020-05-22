public DefaultTableModel map(ResultSet resultSet) throws SQLException
{
    DefaultTableModel defaultTableModel = new DefaultTableModel();

    ResultSetMetaData meta = resultSet.getMetaData();
    int numberOfColumns = meta.getColumnCount();
    while (resultSet.next())
    {
        Object [] rowData = new Object[numberOfColumns];
        for (int i = 0; i < rowData.length; ++i)
        {
            rowData[i] = resultSet.getObject(i+1);
        }
        defaultTableModel.addRow(rowData);
    }

    return defaultTableModel;
}