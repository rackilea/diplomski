class RequestHandler implements Runnable {

    Socket socket;

    protected RequestHandler(Socket socket) {
        this.socket = new SynchronizedSocket(socket);
    }

    public void run() { ..........