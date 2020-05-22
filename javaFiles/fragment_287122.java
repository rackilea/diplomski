Class ServerThread extends Thread {
    StreamConnection connection;

    public ServerThread(StreamConnection connection){
        this.connection = connection;
    }

    public void run() {
        ...

        connection.close();     //closing the connection...don't forget exception handling!
        System.out.println("INFO: Client disconnected");
    }
}