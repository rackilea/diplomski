Server server = ...;
ConnectionWorker worker = new ConnectionWorker(server);
worker.execute();

//...

public class ConnectionWorker extends SwingWorker<Object, Object> {

    private Server server;
    public ConnectionWorker(Server server) {
        this.server;
    }

    @Override
    protected ServerdoInBackground() throws Exception {
        server.doStuff(); //...
        return ...;
    }

}