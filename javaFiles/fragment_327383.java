Socket server = new Socket("192.168.178.32", 1337);
OutputStream outputStream = server.getOutputStream();
FileInputStream in = null;
try {
    in = new FileInputStream("/some/path/to/gras.jpeg");
    // Write to the stream:
    byte[] buffer = new byte[1024]; // 1KB buffer size
    int length = 0;
    while ( (length = in.read(buffer, 0, buffer.length)) != -1 ){
        outputStream.write(buffer, 0, length);
    }
    outputStream.flush();
} finally {
    if (in != null) in.close();
    socket.close(); // Will close the outputStream, too.
}