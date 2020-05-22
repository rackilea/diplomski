final String sql = "call procedureName (:variable)";

    SqlParameterSource namedParameters = new MapSqlParameterSource("variable", variable);

    try {
        namedParameterJdbcTemplate.update(sql, namedParameters);
    } catch (Exception e){
        ...     
      }