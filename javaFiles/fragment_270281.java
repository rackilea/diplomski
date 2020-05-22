Server server = new Server( port );
WebAppContext root = new WebAppContext();

root.setWar("/path/to/somewhere");
root.setContextPath("/");

server.addHandler( root );
server.start();