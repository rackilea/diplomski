public String getColumnType(Connection conn, String columnName)
        throws SQLException {
    try (PreparedStatement ps = conn.prepareStatement("SELECT "
            + columnName + " FROM student")) {
        return ps.getMetaData().getColumnTypeName(1);
    }
}