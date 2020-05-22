public boolean sendTo(String hostname, int port) {
    boolean sent = false;

    try {
        Socket socket = createSocket();
        OutputStream out = socket.getOutputStream();
        out.write(payload);
        socket.close();
        sent = true;
    } catch (UnknownHostException e) {
        // TODO
    } catch (IOException e) {
        // TODO
    }

    return sent;
}

protected Socket createSocket() {
    return new Socket();
}