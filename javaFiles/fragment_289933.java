host = //your hostIP;

String user = "username";
String password = "pwd";


String command = "the command you want to execute";
try {

  java.util.Properties config = new java.util.Properties();
  config.put("StrictHostKeyChecking", "no");
  JSch jsch = new JSch();
  Session session = jsch.getSession(user, host, 22);
  session.setPassword(password);
  session.setConfig(config);
  session.connect();
  System.out.println("Connected");

  Channel channel = session.openChannel("exec");
  ((ChannelExec) channel).setCommand(command);
  channel.setInputStream(null);
  ((ChannelExec) channel).setErrStream(System.err);

  InputStream in = channel.getInputStream();
  channel.connect();
  byte[] tmp = new byte[1024];
  while (true) {
    while (in.available() > 0) {
      int i = in.read(tmp, 0, 1024);
      if (i < 0)
        break;
      area.append(new String(tmp, 0, i));
      //System.out.print(new String(tmp, 0, i)); //command output
    }
    if (channel.isClosed()) {
      System.out.println("exit-status: " + channel.getExitStatus());
      break;
    }
    try {
      Thread.sleep(1000);
    } catch (Exception ee) {
    }
  }
  channel.disconnect();
  session.disconnect();
  System.out.println("DONE");
} catch (Exception e) {
  e.printStackTrace();
  return false;
}