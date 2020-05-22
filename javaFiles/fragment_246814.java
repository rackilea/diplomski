Statement stmt = conn.createStatement();
  // associate the statement with the registration:
  ((OracleStatement)stmt).setDatabaseChangeRegistration(dcr);
 ResultSet rs = stmt.executeQuery("select * from act_code_metadata where      product_id=1159");
  System.out.println("rs.next() "+rs.next());
  while (rs.next())
  {}