public static void main(String args[]) throws Exception {
    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection("jdbc:oracle:thin:@123.43.23.43:8080/orcl", "Test", "*****");

        PreparedStatement ps = con.prepareStatement("select * from MSG where MSD='1234'");
        ResultSet rs = ps.executeQuery();

        try {
            printResultColumns(rs);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        con.close();
    } catch (Exception e) {
        e.printStackTrace();
    }
}