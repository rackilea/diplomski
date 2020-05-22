if (ftpClient.isConnected()) {
   try {
      if (ftpClient.abort()) {
         // Connection aborted!
      }
   } catch (IOException e) {
      e.printStackTrace();
   }
} else {
   // Not connected!
}