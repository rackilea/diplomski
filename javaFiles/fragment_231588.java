try {
    OutputStream socketStream = socket.getOutputStream();
    socketStream.write(buf);
    socket.close();
} catch (IOException e) {
    // try to deal with your I/O error; do logging
} finally {
    closeSilently(socket);
}
...
// Somewhere else, usually part of an utility JAR like Apache Commons IO
public static void closeSilently(Socket s) {
    if (socket != null) {
        try {
            socket.close();
        } catch (IOException e2) {
            // do more logging if appropiate
        }
    }
}