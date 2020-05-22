private static final String SQL_CREATE_TEST_DB = "CREATE DATABASE test";
private static final String SQL_PROD_TABLES = "SHOW TABLES IN production";

JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
jdbcTemplate.execute(SQL_CREATE_TEST_DB);

SqlRowSet result = jdbcTemplate.queryForRowSet(SQL_PROD_TABLES);
while(result.next()) {
    String tableName = result.getString(result.getMetaData().getColumnName(1)); //Retrieves table name from column 1            
    jdbcTemplate.execute("CREATE TABLE test2." + tableName + " LIKE production." + tableName); //Create new table in test2 based on production structure
}