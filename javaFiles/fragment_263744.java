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
  sess.requestPTY("xterm");
  sess.startShell();

  InputStream    stdout = new StreamGobbler(sess.getStdout());
  BufferedReader input  = new BufferedReader(new InputStreamReader(stdout));
  OutputStream   out    = sess.getStdin();
  out.write("nohup sudo <yourCommand> 2>&1 >nohup.out </dev/null &\n".getBytes());
  out.flush();

  while (!input.readLine().contains("stderr")) {
    //Simply move on the stdout of the shell till our command is returned
  }

  sess.close();
  conn.close();
}
catch (IOException e) {
  e.printStackTrace(System.err);
  System.exit(2);
}