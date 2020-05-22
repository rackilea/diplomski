class MyNetworkClass{
  ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
  SocketChannel commchannel; //from the server accept processing

  ...

  public void write(byte[] data){
    //here the class writeBuffer object is filled with the data
    //but it isn't actually sent over the socket
    ...
  }

  public void writePendingData(){
    //here actually write the data to the socket
    commchannel.write(writeBuffer);
  }
}