int port = 12345;

try { 
    java.net.ServerSocket ss = new java.net.ServerSocket(port); 
} catch (java.net.BindException ex) { 
    System.err.println("service is already running and bound to port "+port);
    System.exit(1);
}