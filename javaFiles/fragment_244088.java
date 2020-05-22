JSch jsch = new JSch();

String command = "/tmp/myscript.sh";
Session session = jsch.getSession(user, host, 22);
session.connect();

Channel channel = session.openChannel("exec");
((ChannelExec)channel).setCommand(command);

channel.setInputStream(null);
((ChannelExec)channel).setErrStream(System.err);
InputStream in = channel.getInputStream();
channel.connect();

byte[] tmp = new byte[1024];
while (true) {
  while (in.available() > 0) {
      int i = in.read(tmp, 0, 1024);
      if (i < 0) {
          break;
      }
      System.out.print(new String(tmp, 0, i));
  }
  if (channel.isClosed()) {
      if (channel.getExitStatus() == 0) {
          System.out.println("Command executed successully.");
      }
      break;
  }
}
channel.disconnect();
session.disconnect();