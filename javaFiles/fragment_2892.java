public class DBConnect {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String dbURL = "jdbc:microsoft:sqlserver://localhost:1433;databaseName=TestDB1";
        String user = "sa";
        String pass = "pass";

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        try (Connection myConn = DriverManager.getConnection(dbURL, user, pass);
             Statement myStmt = myConn.createStatement();
             ResultSet myRs = myStmt.executeQuery("Select * from Login")) {

            while (myRs.next()) {
                System.out.println(myRs.getString("Username"));
                System.out.println(myRs.getString("Password"));
            }
        }
    }
}