class Connection {
  private boolean connected; 
  synchronized void setConnected(boolean connected){
    this.connected = connected;
  }
  synchronized boolean isConnected(){
    return connected;
  }
}