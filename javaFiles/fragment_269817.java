public class ConnectionProvider {
    private static final ThreadLocal<Connection> threadLocalConnection = 
         new ThreadLocal<Connection>() {
             @Override 
             protected Connection initialValue() {
                 // TODO create and return the connection
             }
         };

    public static Connection getConnection() {
        return threadLocalConnection.get();
    }
}