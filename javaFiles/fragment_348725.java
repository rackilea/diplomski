final InputStream in = socket.getInputStream();
// This creates a new thread to service the request.
new Thread(new Runnable(){
  public void run(){
    byte[] retrievedData= new byte[ITEM_LENGTH];
    in.read(retrievedData, 0, ITEM_LENGTH);
    in.close();

    // Here call your delegate or something to process the data
    callSomethingWithTheData(retrievedData);
  }
}).start();