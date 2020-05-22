public class ConnectionFactory{
    private static ConnectionFactory instance = new ConnectionFactory();

    public static ConnectionFactory getInstance(){
        return instance;
    }

    private ConnectionFactory(){
    }
}