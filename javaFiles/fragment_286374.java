public class JdbcDaoImpl
{
  public Circle getCircle(int circleId) {
    Connection con = null;
    try {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con = DriverManager.getConnection(
          "jdbc:oracle:thin:@localhost:1521:xe","saral","saral");
      final PreparedStatement stmt = con.prepareStatement(
          "select * from CIRCLE where id = ?");
      stmt.setInt(1,circleId);
      final ResultSet rset = stmt.executeQuery();
      if (rset.next()) return new Circle(circleId, rset.getString("name") );
      throw new RuntimeException("Result set is empty");
    }
    catch (RuntimeException e) { throw e; }
    catch (Exception e) { throw new RuntimeException(e); }
    finally { try { if (con != null) con.close(); } catch (Throwable t) {} }
  }
}