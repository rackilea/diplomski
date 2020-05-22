DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection conn = DriverManager.getConnection("jdbc:oracle:oci8:@", "QUINE", "CURRY");
OraclePreparedStatement stmt = (OraclePreparedStatement) conn.prepareStatement(
     "SELECT XMLSerialize(DOCUMENT e.poDoc AS BLOB) poDoc FROM po_xml_tab e");
ResultSet rset = stmt.executeQuery();
OracleResultSet orset = (OracleResultSet) rset;
while(orset.next())
{
  // the first argument is a BLOB
  oracle.sql.BLOB clb = orset.getBLOB(1);
  // now use the BLOB inside the program
}