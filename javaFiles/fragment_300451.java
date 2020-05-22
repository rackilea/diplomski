File fileToSend;
InputStream fileStream = new BufferedInputStream(fileToSend);

Socket connection = new Socket(CONNECTION_ADDRESS, LISTENING_PORT);
OutputStream out = connection.getOutputStream();

// my method to move data from the file inputstream to the output stream of the socket
copyStream(fileStream, out);