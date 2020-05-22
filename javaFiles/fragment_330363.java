private jdbcTemplate = new JdbcTemplate(myDataSource);
try{
  CallableStatement callableStatement = jdbcTemplate.getDataSource().getConnection().prepareCall("{call PACKAGE_NAME.STORED_PROCEDURE_NAME}");
  callableStatement.executeUpdate();
} catch(SQLException e)
{
...
}