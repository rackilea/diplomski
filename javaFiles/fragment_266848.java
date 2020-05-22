String sql = "SELECT col1, col2, col3 "
       + "FROM my_awesome_table "
       + "WHERE strValue IN (:items)";

getSimpleJdbcTemplate().query(
    sql
,   Collections.singletonMap("items", strValues)
,   resultObjectRowMapper()
);