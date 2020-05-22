public class Server ... {
    private volatile boolean isRunning = true;
    public boolean isRunning() { return this.isRunning; }
    ...
}

public class Process implements Runnable {

    private final Server server;

    public Process(Server server) {
        this.server = server;
    }

    @Override
    public void run() {
        ...
        while(server.isRunning()) {...}
        ...
    }

}