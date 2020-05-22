public class YourDao extends JdbcDaoSupport{

  public void updateMethod(){
    String sql = "update example set id = ?";
    getJdbcTemplate().update(sql, new Object[] { new Integer(1)});           
  }

}