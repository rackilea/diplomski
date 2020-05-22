public class Test{

    private Connection conn;

    private PreparedStatement prstmt;

    private ResultSet rs;

    public void testMethod() {

try {
            conn = ConnectionDB.getDS().getConnection();

            //create your sql, result sets and prepare statements

 }
catch (SQLException e) {
            e.printStackTrace();
        } 

}

}