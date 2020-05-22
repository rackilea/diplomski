public boolean testConnection() {
  boolean connectionStatus=false;

  try {
      InetAddress addr=InetAddress.getByName("8.8.8.8");//here type proxy server ip      


      connectionStatus=addr.isReachable(1000); // 1 second time for response

  }                               
  catch (Exception e) {
      e.printStackTrace();
      System.out.println(e.toString());
  }

  return connectionStatus;
}