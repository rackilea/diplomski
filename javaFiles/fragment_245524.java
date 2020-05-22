public static FtpConnectTask getInstance(FTPClientWrapper ftpClient) {
   if (instance != null) {
      if (instance.getStatus().name().toLowerCase().equals("running"){
         instance.cancel(true);
      }
      if (instance.getStatus().name().toLowerCase().equals("finished")) {
          // task finished!
      }
   }
   instance = new FtpConnect(uiListener, ftpClientW);
   return instance;
}