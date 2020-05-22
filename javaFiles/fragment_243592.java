ServerSocket socket = new ServerSocket(8888);
Socket cSocket = socket.accept();

PrintWriter out = null;
try {
    out = new PrintWriter(new OutputStreamWriter(cSocket.getOutputStream()));

    for (String file : new File(".").list()) {
        out.println(file);
    }
}
finally {
    if (out != null) {
        out.close();
    }
    cSocket.close();
    socket.close();
}