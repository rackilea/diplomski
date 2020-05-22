public void sendData(String data){ //Client code
try{
DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
  outToServer.writeBytes(data + "\n");
}catch (Exception e){

}
}