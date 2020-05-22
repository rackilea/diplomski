public void copyFromSmbToSftp(SmbFile smbFile, ChannelSftp channelSftp, String destPath) throws IOException, SftpException {
    try(BufferedInputStream inputStream = new BufferedInputStream(smbFile.getInputStream());
        BufferedOutputStream outputStream = new BufferedOutputStream(channelSftp.put(destPath))){
      byte[] buffer = new byte[64*1024];
      int bytesRead;
      while((bytesRead=inputStream.read(buffer, 0, buffer.length))!=-1){
        outputStream.write(buffer, 0, bytesRead);
      }
    }
  }