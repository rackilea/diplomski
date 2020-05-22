public String getZipFirstEntryName(final String remotePath) {                                                                                
    this.log.info("ENTERING getZipFirstEntry, remotePath={} ", remotePath);                                                                  

    /* Setup FTP connection */                                                                                                               
    final FTPClient ftpClient = this.setupFtpConnection();                                                                                   


    try {                                                                                                                                    
        ftpClient.changeWorkingDirectory(remotePath.split("/")[0]); /* ftp-folder */                                                                       
    } catch (final IOException e) {                                                                                                          
        e.printStackTrace();                                                                                                                 
    }                                                                                                                                        

    try (final ZipArchiveInputStream zip = new ZipArchiveInputStream(ftpClient.retrieveFileStream(remotePath.split("/")[1]))) { /* input.txt */             

        this.log.info("EXITING getZipFirstEntry, remotePath={} ", remotePath);                                                               
        return zip.getNextEntry().getName();                                                                                                 

    } catch (final IOException e) {                                                                                                          
        e.printStackTrace();               
    }                                                                                                                                        

}