boolean downloadFile(String remoteFilePath, String localFilePath) {
  try {
    File localFile = new File(localFilePath);
    if (localFile.exists()) {
      // If file exist set append=true, set ofset localFile size and resume
      OutputStream fos = new FileOutputStream(localFile, true);
      ftp.setRestartOffset(localFile.length());
      ftp.retrieveFile(remoteFilePath, fos);
    } else {
      // Create file with directories if necessary(safer) and start download
      localFile.getParentFile().mkdirs();
      localFile.createNewFile();
      val fos = new FileOutputStream(localFile);
      ftp.retrieveFile(remoteFilePath, fos);
    }
  } catch (Exception ex) {
    System.out.println("Could not download file " + ex.getMessage());
    return false;
  }
}