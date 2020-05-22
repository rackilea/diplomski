public class ConnectionDB {

    private Context initContext;

    private static Context webContext;

    private static DataSource dataSource = null;

    private ConnectionDB() {
        try {
            initContext = new InitialContext();

            webContext = (Context) initContext.lookup("java:/comp/env");

            dataSource = (DataSource) webContext.lookup("name_ds");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDS() {

        if (dataSource == null) {
            new ConnectionDB();
        }

        return dataSource;

    }

}