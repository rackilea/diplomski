public static void main(String args[]) throws Exception {
    // registration for the driver, it's needed, 
    // otherwise there will be "no suitable driver found"
    Class.forName("oracle.jdbc.driver.OracleDriver");

    try (Connection conn = DriverManager.getConnection(
            "jdbc:oracle:thin:@128:23:44:01:12345:pppp_rr", "Test123", "********")) {

        if (conn != null) {
            System.out.println("Connected to the database!");
        } else {
            System.out.println("Failed to make connection!");
        }

    } catch (SQLException e) {
        System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
    } catch (Exception e) {
        e.printStackTrace();
    }
}