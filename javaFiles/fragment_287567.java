boolean serverDone = false;
while (!serverDone) {
  String message = in.readLine();
  if (message == null) {
    // handle this problem: the server has closed the connection
    serverDone = true; // or return, or throw
  } else if ("END-OF-MESSAGE".equals(message)) {
    serverDone = true;
  }
}