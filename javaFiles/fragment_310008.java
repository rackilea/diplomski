public class MySingletonConnection{
    private static final MySingletonConnection INSTANCE = new MySingletonConnection();
    private Connection myConnection;
    private Singleton(){ 
      // here you can init your connection parameter
    }

    public static MySingletonConnection getInstance(){
        return INSTANCE;
    }

 public Connection getConnection( ) {
    return connection;
}
}