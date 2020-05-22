String groupFormat = "YYYYMMDD";

String sql = "select c.created_dt, to_char(c.created_dt, :groupFormat) as point" + 
        "      ,count(*) as CNT" + 
        "  from your_table c" + 
        " group by c.created_dt";

MapSqlParameterSource namedParameters = new MapSqlParameterSource();
namedParameters.addValue("groupFormat", groupFormat);

dbSelector.gssNamedJdbcTemplate().query(sql, namedParameters, rs -> {
    logger.info(rs.getString(1));

});