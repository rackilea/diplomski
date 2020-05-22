public class MyJdbcMigration implements SpringJdbcMigration {
  public void migrate(JdbcTemplate jdbcTemplate) {
    MyJdbcDao dao = new MyJdbcDao();
    dao.setJdbcTemplate(jdbcTemplate);
    dao.updateDate();
  }
}