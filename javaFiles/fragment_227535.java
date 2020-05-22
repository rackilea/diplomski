import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

class ConnectorService extends Thread {

    static Map<String, Thread> connectorServices = new HashMap<>();

    Socket connection;
    ObjectInputStream in;
    ObjectOutputStream out;
    Thread _t;

    public ConnectorService(String name, Socket sock, ObjectInputStream _in, ObjectOutputStream _out) {
        this.connection = sock;
        try {
            in = _in;
            out = _out;
            out.flush();
        } catch (Exception e) {
            System.err.println("Wystapil blad laczenia do socketu..");
        }
        // add this to the list of references to the threads
        ConnectorService.connectorServices.put(name, this);
    }

    @Override
    public void run() {

        this.send("Siemka :P");

        while (true) {
            try {
                String mess = (String) in.readObject();

                String[] m = mess.split(":");

                if (m.length > 1) {
                    Thread _tmp;
                    if ((_tmp = getThreadByName(m[0])) != null) {
                        // Here i've got an exception
                        ((ConnectorService) _tmp).send(m[1]);
                    }
                } else {
                    System.err.println("Zbyt malo argumentow..");
                }

                this.getThreadByName("test");
                System.out.println("Klient: " + mess);
                this.send(mess);
            } catch (ClassNotFoundException e) {
                System.err.println("Bledny typ wiadomosci..");
            } catch (IOException e) {
                // e.printStackTrace();
                System.err.println("Polaczenie przerwane..");
                break;
            }
        }

    }

    public void start() {
        System.out.println("Uruchamiam klienta");
        if (_t == null) {
            _t = new Thread(this);
            _t.start();
        }
    }

    public void send(String message) {
        try {
            out.writeObject(message);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Thread getThreadByName(String threadName) {
        return ConnectorService.connectorServices.get(threadName);
    }
}