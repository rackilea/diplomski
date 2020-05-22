try {
    JSch jsch = new JSch();
    session = jsch.getSession(userName, remoteHost, port);
    session.setPassword(userPassword);

    Properties prop = new Properties();
    prop.put("StrictHostKeyChecking", "no");
    session.setConfig(prop);

    session.setConfig("PreferredAuthentications",
                "password"); //add this line to your code

    session.connect();

    channel = session.openChannel("sftp");          
    channel.connect();
    channelSftp = (ChannelSftp)channel;

} catch (Exception ex) {
    ex.printStackTrace();
    session.disconnect();
}