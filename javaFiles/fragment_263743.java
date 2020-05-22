import ch.ethz.ssh2.*

String hostname    = "localhost";
String username    = "gsus";
File   keyfile     = new File("/home/gsus/.ssh/id_rsa");
String keyfilePass = "";

try {
  Connection conn = new Connection(hostname);
  conn.connect();

  boolean isAuthenticated=conn.authenticateWithPublicKey(username,keyfile,keyfilePass);
  if (isAuthenticated == false)
    throw new IOException("Authentication failed.");

  Session sess=conn.openSession();
  //Don't use this
  //sess.requestDumbPTY();

  sess.execCommand("nohup sudo ping -c 100 www.yahoo.com 2>&1 >nohup.out </dev/null &");

  sess.close();
  conn.close();
}
catch (  IOException e) {
  e.printStackTrace(System.err);
  System.exit(2);
}