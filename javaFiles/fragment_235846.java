DataInputStream din = new DataInputStream( new BufferedInputStream( socket.getInputStream() ) );
DataOutputStream dout = new DateOutputStream( new BufferedOutputStream( socket.getOutputStream() );
try {


} finally {
   din.close();
   dout.close();
}