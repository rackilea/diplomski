jdbcTemplate.query(sql, params, new ColumnMapRowMapper() {
    @Override
    protected Object getColumnValue(ResultSet rs, int index) {
       return rs.getString(index);
    }
}