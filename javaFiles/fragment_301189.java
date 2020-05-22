public class ConnectionUsage {

    public static void main(String[] args) {
        // you can get the connection and do stuff
        AmqpConnection connection = ConnectionUtil.getConnection();


        // you can call the util and let him do stuff
        Function<AmqpConnection, Void> func = amqpConnection -> {
            // do stuff
            return null;
        };
        ConnectionUtil.doWithConnection(func);
    }
}