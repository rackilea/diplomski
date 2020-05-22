public class Foo {
  class AppleRows implements RowMapper<Apple> {
    public Apple mapRow(ResultSet rs, int rowNum) throws SQLException {
      Apple a = new Apple();
      a.setName(rs.getString("Name"));
      return a;
    }
  }

  class AppleRowsJoinedWithSomethingElse implements RowMapper<Apple> {
    public Apple mapRow(ResultSet rs, int rowNum) throws SQLException {
      Apple a = new AppleRows().mapRow(rs, rowNum);
      a.setSomethingElse(rs.getString("SomethingElse"));
      return a;
    } 
  }
}