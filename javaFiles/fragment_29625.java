class Connector implements Serializable {

    private static final long serialVersionUID = 1L;
    private static ResourceBundle prop = ResourceBundle.getBundle("dbdetails");
    private static MysqlDataSource dataSource = null;

    // Dont allow any instance of this class
    private Connector(){
    }

    private static void initDataSource()
    {
        try 
        {
            dataSource = new MysqlDataSource();
            dataSource.setURL(prop.getString("DB_URL"));
            dataSource.setUser(prop.getString("DB_USER"));
            dataSource.setPassword(prop.getString("DB_PASS"));
        } 
        catch (SQLException e) {
            // handle the Exception according to your application demand
        }
    } 
    /*
     * Return a connection from the datasource pool 
     */
    public static Connection getConnection() throws Exception {
       if(dataSource == null)
       {
           initDataSource();
       }
       return dataSource.getConnection();
    }

}