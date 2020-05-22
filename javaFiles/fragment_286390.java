try (Socket socket = serverSocket.accept()) 
{
  Thread newThread = new Thread(new server(socket));
  newThread.start();
}
// socket is closed by here, but newThread may still be running.