JSch jsch = new JSch();
Session session = jsch.getSession("remote_user_name", "remote_host_or_ip", 22); // 22 for SFTP
session.setPassword("remote_password");


java.util.Properties config = new java.util.Properties();
config.put("StrictHostKeyChecking", "no");
session.setConfig(config);

session.connect(10000);
Channel channel = session.openChannel("sftp");
channel.connect();

System.out.println("Connection Opened");
ChannelSftp channelSftp = (ChannelSftp) channel;
InputStream inputStream = new FileInputStream("text_file.txt");
channelSftp.put(inputStream, "/remote/folder/file_to_be_rewritten.txt");

System.out.println("File should be uploaded");

channelSftp.disconnect();
session.disconnect();