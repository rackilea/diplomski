FtpClient ftpClient = new FtpClient() ;
 ...
 //Opens a new socket
 ftpClient.connect("ftp.example.com");
 ...

 Runnable run = new ThreadUpload(JFrameClass.this, ftpClient);
 new Thread(run).start();