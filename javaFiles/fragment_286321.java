public void updateColumns(String tableName, List<String> cols, ResultSet rs, String like, String newValue) {
    PreparedStatement ps = conn.prepareStatement("UPDATE "+tableName+" SET "+column+" = ? WHERE "+column+" = ? ");
    while(rs.next()) {
        for(String column : cols) {
            String value;
            if((value = rs.getObject(column).toString()).matches(".*"+like+".*")) {
                ps.setString(1, newValue);
                ps.setString(2, value);
                ps.addBatch();
            }
        }
    }
    ps.executeBatch();
    ps.close();
    // rs.close();
}

// updateColumns("table_name", columns, resultSet, textField.getText(), textField2.getText());