public final class HiveBasicClient {

    private static String driverName = "org.apache.hadoop.hive.jdbc.HiveDriver";
    private static Connection con;

    private static Connection getConnection(String hiveServer, String hivePort, String hadoopUser, String hadoopPassword) {
        try {
            Class.forName(driverName);
        } catch (ClassNotFoundException e) {
            return null;
        }

        try {
            return DriverManager.getConnection("jdbc:hive://" + hiveServer + ":" + hivePort + "/default?user=" + hadoopUser + "&password=" + hadoopPassword);
        } catch (SQLException e) {
            return null;
        } 
    }

    private static res doQuery(String query) {
        try {
            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery(query);
            res.close();
            stmt.close();
            return res;
        } catch (SQLException ex) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        String hiveServer = args[0];
        String hivePort = args[1];
        String hadoopUser = args[2];
        String hadoopPassword = args[3];

        con = getConnection(hiveServer, hivePort, hadoopUser, hadoopPassword);
        doQuery("create external table <table_name> (<list_of_columns>) row format serde '<your_xml_serde>' location `<your_xml_files_location>');
    }

}