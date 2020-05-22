public class ConnectionUtil {

    private static AmqpConnection connection;

    private static Lock lock = new ReentrantLock();

    public static AmqpConnection getConnection() {
        if (connection == null) {
            lock.lock();
            if (connection == null) {
                AmqpClient client = AmqpClient.create(someOptions);
                client.connect(ar -> {
                    if (ar.failed()) {
                        System.out.println("Connection failed.");
                    } else {
                        System.out.println("Connection succeeded");
                        connection = ar.result();
                    }
                });
            }
            lock.unlock();
        }
        return connection;
    }

    public static <T> T doWithConnection(Function<AmqpConnection, T> function) {
        return function.apply(getConnection());
    }
}