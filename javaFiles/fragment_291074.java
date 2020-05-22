PreparedStatement stmt = cnt.prepareStatement("...");
try {
    /* ... */
    ResultSetMetaData meta = stmt.getMetaData();
    Object row[] = new Object[meta.getColumnCount()];
    ResultSet rs = stmt.executeQuery();
    while (rs.next()) {
        for (int i = 0; i < row.length; ++i) {
            row[i] = rs.getObject(i+1);
        }
        processRow(row);
    }
} finally {
    stmt.close();
}