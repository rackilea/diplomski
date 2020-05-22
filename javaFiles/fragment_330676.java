JSch jsch = new JSCH();
Session session = jsch.getSession(config.getUsername(), config.getHostname(), config.getPort()); //port is usually 22
session.setPassword(config.getPassword());

session.connect();

Channel channel = session.openChannel("sftp");
channel.connect();
ChannelSftp cFTP = (ChannelSftp) channel;

String sourceFile = "---", targetFile = "---";
cFTP.put(sourceFile , targetFile );

cFTP.disconnect();
session.disconnect();