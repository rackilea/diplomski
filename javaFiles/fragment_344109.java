public void testJndiDataSource(int salaryInt, double takeHomePAYE, String takeHomeContractor) {
    Connection conn = null;
    Statement st = null;
    ResultSet rs = null;
    try {
        InitialContext ctx = new InitialContext();
        DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CrunchDB");

        conn = ds.getConnection();

        st = conn.createStatement();
        st.executeUpdate("INSERT INTO log " + "VALUES (20, '1', '1', " + process.salaryInt + ", "+ process.takeHomePAYE +", "+ process.takeHomeContractor +", 2)");


    } catch (Exception ex) {
        ex.printStackTrace();
    } finally {
        try { if (rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (st != null) st.close(); } catch (SQLException e) { e.printStackTrace(); }
        try { if (conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
    }
}