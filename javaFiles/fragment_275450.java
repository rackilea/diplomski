String SERVER_IP = "ip";
int PORT = 0;
int maxTries = 10;
int timeBeforeRetry = 5000; //ms
int count = 0;
Socket clientSocket = null;
while(clientSocket == null && count < maxTries) {
  try {
    clientSocket = new Socket(SERVER_IP, PORT);
  } catch(IOException e) {
    // Log if you want
    try {
      Thread.sleep(timeBeforeRetry);
    } catch(InterruptedException e) { /* can be ignored or logged I guess */ }
  }
  count++;
}

if(clientSocket == null) {
  // throw some kind of exception
}