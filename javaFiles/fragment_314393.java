Session sessionB = jsch.getSession("usernameB", "hostB", 22);
// ...
sessionB.connect();

int forwardedPort = 2222; // any port number which is not in use on the local machine
sessionB.setPortForwardingL(forwardedPort, "hostC", 22);

Session sessionC = jsch.getSession("usernameC", "localhost", forwardedPort);
// ...
sessionC.connect();

Channel channel = sessionC.openChannel("sftp");
channel.connect();
ChannelSftp channelSftp = (ChannelSftp)channel;           

channelSftp.put("C:\\local\\path\\file.txt", "/remote/path/on/C/file.txt");