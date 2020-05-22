public class DbWrapper {
    private Connection conn = null;
    String jdbc_url="jdbc:oracle:thin:hr/hr@localhost:1521:XE";

    public DbWrapper() {
        conn=DriverManager.getConnection(jdbc_url);
    }

    public Arraylist<User> getUsers() {
         ...
    }
}