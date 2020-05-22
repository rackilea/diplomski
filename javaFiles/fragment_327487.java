public Object[] getId() {
  Connection con;
  Statement stmt;
  ResultSet rs;

  //Object[] returnId;
  ArrayList<Object> returnId = new ArrayList<Object>();
  try {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    con = DriverManager.getConnection("jdbc:odbc:collegesys","root","0blivi0n");

    stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
    rs = stmt.executeQuery("SELECT `id` FROM main");

    while(rs.next()) {
      returnId.add(rs.getObject("id"));
    }

    con.close();
  } catch(Exception e) {
    e.printStackTrace();
  }
  return returnId.toArray(new Object[returnId.size()]);
}