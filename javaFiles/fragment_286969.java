private Object semaphore = new Object();

public void processMessage(Socket socket) {
    synchronize(semaphore) {
        char[] data = buildData(socket.getInputStream());
        int primaryKey = saveRecord(data);
        // do something else
    }
}

public char[] buildData(InputStream inputStream) {
    return new char[5];
}

public int saveRecord(char[] data) {
    // save to database and return primary key
}

Runnable runnable = new Runnable() {
    public void run() {
        processMessage(socket.getInputStream());
    }
};
new Thread(runnable).start();

Runnable runnable2 = new Runnable() {
    public void run() {
        processMessage(socket.getInputStream());
    }
};
new Thread(runnable2).start();