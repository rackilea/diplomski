public void tableView() throws SQLException, ClassNotFoundException {
    Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

    //Create new table model
    DefaultTableModel tableModel = new DefaultTableModel();

    try (Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/TESTTABLE", "me", "1234")) {
        String sql = "SELECT DATA1, DATA2 FROM ME.SOMETABLE";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            try (ResultSet rs = ps.executeQuery()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                List<String> columnNames = new ArrayList<>(columnCount);
                for (int column = 0; column < columnCount; column++) {
                    columnNames.add(rsmd.getColumnName(column + 1));
                }

                tableModel.setColumnIdentifiers(columnNames.toArray(new Object[columnNames.size()]));

                while (rs.next()) {
                    Object row[] = new Object[columnCount];
                    for (int column = 0; column < columnCount; column++) {
                        row[column] = rs.getObject(column + 1);
                    }
                    tableModel.addRow(row);
                }
            }
        } finally {
            t.setModel(tableModel);
        }
    }
}