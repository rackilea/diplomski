...
int backport;
String msg ="Second Hi!!!!!";
socket_connect sc = new socket_connect("127.0.0.1",8080);
// add try catch or throw 
// by this time hopefully the socket_connect will start.
Thread.sleep(1000);
backsock = sc.getSocket();
backhost = sc.getHost();
backport = sc.getPort();
System.out.println(backhost + " " + backport);