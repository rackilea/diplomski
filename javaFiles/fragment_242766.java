class Runner implements Runnable {

final private int startPort;

public Runner(String host, int startPort) {
        this.host = host;
        this.startPort = startPort;
    }

    public void run() {
        for (int port = startPort; port <= NUMBER_OF_PORTS_PER_THREAD + startPort; port++) {
        ...
    }
}