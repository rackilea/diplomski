public static void main(String[] args) {
    String connString = "jdbc:oracle:thin:@host:port:SID";
    System.out.println(validateConnection(connString));
}

public static boolean validateConnection(String connString) {

    try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(connString, "x", "y");
    } catch (SQLException sqle) {
        if (sqle.getErrorCode() == 1017)
            return true;
    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}