Class.forName("oracle.jdbc.driver.OracleDriver");
List<Customer> cs = new ArrayList<Customer>();
Connection con = null;
Statement stmt = null;
ResultSet rs = null;
try {
    con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "invoice", "google");
    stmt = con.createStatement();
    rs = stmt.executeQuery("select customerid,customername from customer order by customerid asc");
    while (rs.next()) {
        Customer cm = new Customer();
        cm.setCustomerid(rs.getInt(1));
        cm.setCustomername(rs.getString(2));
        cs.add(cm);
    }
} catch (Exception e) {
    LOG.error("Error connecting to DB: " + e.getMessage(), e);
} finally {
    try {
        // close resources
        rs.close();
        stmt.close();
        con.close();
    } catch (Exception e) {// ignore
    } finally {
        // setting everything to null (allows Objects to be GC'd)
        rs = null;
        stmt = null;
        con = null;
    }
}
return cs;