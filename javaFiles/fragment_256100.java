public static <T> List<T> queryList(String query, Connection conn, RowMapper<T> rowMapper) throws SQLException {
    LOGGER.debug("Executing query = {}", query);
    try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        List<> list = new ArrayList<>();    
        while (rs.next()) {
            list.add(rowMapper.mapRow(rs, list.size() + 1)); 
        }
        return list;
    } finally {
        DBUtil.closeResultSet(rs);
        DBUtil.closeStatement(stmt);
        LOGGER.debug("Finished query = {}", query);
    }
}