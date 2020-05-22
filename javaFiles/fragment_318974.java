public class Oracle {

    public static void main(final String[] args) throws ClassNotFoundException, SQLException {
        final Connection con;

        try {
            Class.forName ("oracle.jdbc.driver.OracleDriver"); 
        } catch (final Exception e) {
            throw new RuntimeException("Driver failure");
        }

        try {
            con = DriverManager.getConnection ("jdbc:oracle:thin:schema/password@host:port:sid");
        } catch (final Exception e) {
            throw new RuntimeException("Login failure");
        }


        try {
            final Statement stmt = con.createStatement();

            final String sql = "select 1 from dual";
            final ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()) {
                // do something with the data
            }
            rs.close();
        } catch (final Exception e) {
            throw new RuntimeException("SQL failure");
        }
    }
}