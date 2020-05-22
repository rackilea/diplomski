// Client.java

/*
 * This is still server side, that is the handler for the connected clients
 */
public class Client implements Runnable {

    public static final long IDLE_TIME = 10;

    private Connection  connection;
    private boolean     alive;
    private Thread      t;

    private List<Client> clientList;

    public Client(Connection connection, List<Client> clientList) {
        this.connection = connection;
        this.clientList = clientList;
        alive = false;
    }

    public synchronized void startSession() {

        if (alive)
            return;

        alive = true;

        t = new Thread(this);
        t.start();

    }

    public synchronized void closeSession() {

        if (!alive)
            return;

        alive = false;

        try {
            connection.close();
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {

        while (connection.isAlive()) {

            String in = connection.read();
            if (in != null) {
                System.out.println(in);
                for (Client c : clientList) {
                    c.send(in);
                }
            } else {
                try {
                    Thread.sleep(IDLE_TIME);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    public void send(String msg) {

        connection.write(msg + "\n");
        connection.flush();
    }

}