private class FtpTask extends AsyncTask<Void, Void, FTPClient> {
     protected FTPClient doInBackground(Void... args) {
        serverconnection ftpconnect =new serverconnection();
        FTPClient ftp=ftpconnect.connectftp();
        return ftp;
     }

     protected void onPostExecute(FTPClient result) {
         Log.v("FTPTask","FTP connection complete");
         ftpClient = result;
         //Where ftpClient is a instance variable in the main activity
     }
 }