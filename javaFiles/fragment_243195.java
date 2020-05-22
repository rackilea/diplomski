public void run(){
  while (socket.isConnected()) {
    if (input.hasNext()) {
      String nextInput = input.next();
      myGui.updateTextField(nextInput);
    }
  }
}