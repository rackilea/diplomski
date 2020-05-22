public class MySqlConnect {


    public static Connection connectToDB() {
        try {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setServerName("localhost");
            dataSource.setDatabaseName("auto_lube");
            dataSource.setPortNumber(3306);
            dataSource.setUser("root");
            dataSource.setPassword("mehar");

            Connection conn = dataSource.getConnection();
            JOptionPane.showMessageDialog(null, "Connection established"); // better log this message
            return conn;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e); // better log the exception
            return null;
        }
    }
}