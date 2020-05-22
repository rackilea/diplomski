class Connector implements Serializable {

private static final long serialVersionUID = 1L;
private static ResourceBundle prop = ResourceBundle.getBundle("dbdetails");;
private static Connection con = null;

// Dont allow any instance to be created for this class
private Connector(){
}

private static void initConnection() throws  Exception
{
    Class.forName((String) prop.getString("DB_DRIVER"));
    con = DriverManager.getConnection((String) prop.getString("DB_URL"),
            (String) prop.getString("DB_USER"),
            (String) prop.getString("DB_PASS"));
}

public static Connection getConnection() throws Exception {
    if(con == null)
    {
        initConnection();
    }
    return con;
}