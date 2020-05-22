class RemoteLogger implements Runnable, Appender {
    final StringBuffer buffer = new StringBuffer();

    void append(String s) {
        buffer.append(s);
    }

    public void run() {
        for (;;) {
            Thread.sleep(100);

            String message = buffer.toString();
            sendToServer(message);
            buffer.delete(0, message.length());
        }
    }
}