public static void main(String args[]) {

  Connection con = null;
  PreparedStatement pst = null;
  ResultSet rs = null;

  try {

  Class.forName(driver);
  con = DriverManager.getConnection(connection);

  String sql =
  "select * from Employees where FirstName " + "in(?,?,?)";
  pst = con.prepareStatement(sql);

  pst.setString(1, "komal");
  pst.setString(2, "ajay");
  pst.setString(3, "santosh");

  rs = pst.executeQuery();
  System.out.println("EmployeeID\tFirstName");
  while (rs.next()) {
  System.out.print("  "+rs.getString(1));
  System.out.print("\t\t"+rs.getString(2));
  System.out.println("\t\t"+rs.getString(3));
  }

  } catch (Exception e) {
  System.out.println(e);
  }
  }
}