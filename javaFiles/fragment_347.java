ServerSocket soc = new ServerSocket(port);

while (true) {
  try {
    if (StopService) {
      soc.close();
      break;
    }

    Socket s = soc.accept();
    new Thread(new ConnectionHandler(s)).start(); 
  } catch (SocketTimeoutException ex) {
  } catch (IOException ex) {
    ex.printStackTrace();
  }
}