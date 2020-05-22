public final List<Column> getColumnsByOwner(final String owner) {
    final String sql = "SELECT COLUMN_NAME, DATA_TYPE, DATA_LENGTH, "
            + " DATA_PRECISION, DATA_SCALE, NULLABLE, DATA_DEFAULT"
            + " FROM ALL_TAB_COLUMNS"
            + " WHERE OWNER = ? ORDER BY COLUMN_ID";

    return jdbcTemplate.query(sql,
            new Object[] { owner },
            new RowMapper<Column>() {
                @Override
                public Column mapRow(final ResultSet res, final int rowNum)
                        throws SQLException {
                    final Column reg = new Column();

                    reg.setColumnName(res.getString("COLUMN_NAME"));
                    //Read other properties
                    reg.setNullable(res.getString("NULLABLE").equals("Y"));
                    return reg;
                }
            });
}