public JComboBox<String> comboBox() throws SQLException
{
    ResultSet rs = connecting.getMetaData().getTables(null, null, "%", null);

    ResultSetMetaData meta = (ResultSetMetaData) rs.getMetaData();

    int columns = meta.getColumnCount();

    while(rs.next())
    {

            String table_names = rs.getString("TABLE_NAME");
            combo.addItem(table_names);
    }

    combo.setBounds(130,30,190,30);
    combo.setSelectedIndex(0);
    combo.setMaximumRowCount(5);
    return combo;
}