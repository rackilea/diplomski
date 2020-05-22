public class ActiviteBD { 

    Connection connection = null;

    public Connection getConnection() throws Exception {
        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:D:\\THEPATH\\Project\\agenda.db");
            System.out.println(connectionURL);
            return connection;
        } catch (Exception e) {
            throw e;

        }

    }