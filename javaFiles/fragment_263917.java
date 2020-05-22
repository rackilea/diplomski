// session and channel are at the object scope
Session session = null;
Channel channel = null;

public InputStream getFile(String path){
    // First, close any existing connections.
    try {
      closeConnexion();
    } catch (SftpException e) {
      // You can try to handle an issue here; but it's
      // probably not worth it
    }
    try {
      ChannelSftp sftp = openConnexion();
      return sftp.get(path);
    } catch (SftpException e) {
      new RuntimeException("Error detected during get file from SFTP specific path : " + e.getMessage(), e);

    } finally {
    }
 }

 private ChannelSftp openConnexion() {
    try {
      JSch ssh = new JSch();
      // use the object's session variable
      session = ssh.getSession("user", "hostname", 22);
      session.setPassword("password");
      session.setConfig("StrictHostKeyChecking", "no");
      session.connect();
      // use the object's channel object
      channel = session.openChannel(SFTP_CHANNEL);
      channel.connect();
      ChannelSftp sftp = (ChannelSftp) channel;

      return sftp;

    } catch (JSchException e) {
      throw new RuntimeException("Error detected during open SFTP connexion : " + e.getMessage(), e);
    }
  }

  private void closeConnexion() {
    // close object's channel and session
    if (channel != null) {
      channel.disconnect();
      channel = null;
    }
    if (session != null) {
      session.disconnect();
      session = null;
    }
  }