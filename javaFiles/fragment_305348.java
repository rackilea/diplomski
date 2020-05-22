public void startFTPUpload(String strUserInfo) {
    AccessController.doPrivileged(new PrivilegedAction<Boolean>() {
        public Boolean run() {
            try {
                final FTPClient ftpclient = new FTPClient();

                File myFile;
                try {

                    FTPUtils.ftpConnect(ftpclient, "host", "username", "password");
                    ftpclient.setFileType(FTP.BINARY_FILE_TYPE);

                    for(int i = 0; i < files.length; i++) {
                        String to = "/tekmtn.com/sites/testingsite.com/files/queue";
                        ftpclient.changeWorkingDirectory(to);
                        ftpclient.printWorkingDirectory();
                        myFile = new File(files[i].getAbsolutePath());
                        final String remoteFile = myFile.getName();

                        FTPUtils.uploadFile(ftpclient, files[i].getAbsolutePath(), remoteFile);
                        boolean completed = ftpclient.completePendingCommand();
                        if(completed) {
                            lblStatus.setText((i+1) + " files have been uploaded successfully.");
                        }
                    }
                } catch (IOException ex) {
                    // TODO Auto-generated catch block
                    lblStatus.setText(ex.getMessage());
                    //ex.printStackTrace();
                }
                //myLabel.setText("UserId " + userId + " is now set.");
            } catch (Exception e) {
                lblStatus.setText(e.getMessage());
            }
            return Boolean.TRUE;
        }
    });
}