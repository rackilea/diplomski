public class C_DB {

    private static C_DB instance;

    private Connection con;

    private C_DB() {
        String dbLink = "jdbc:mysql://localhost:3306/database";
        String dbUser = "root";
        String dbPass = "";
        try {
            con = DriverManager.getConnection(dbLink, dbUser, dbPass);
        } catch (SQLException e) {
            throw new IllegalStateException("DB Errors: ", e);
        }
    }

    public static Connection getConnection(){
        if(instance == null){
           instance = new C_DB();
        }
        return instance.con;
    }

}