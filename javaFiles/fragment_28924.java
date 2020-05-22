private class FTPUploadTask extends AsyncTask<AFileDescriptor, Long, Boolean> {

    private static final int bufferSize = 64;
    private boolean isCanceling = false;
    private long fileSize = 0;

    private ProgressDialog pd;

    @Override
    protected void onPreExecute() {
        pd = new ProgressDialog( ThisActivity.this );
        pd.setCancelable( false );
        pd.setMessage( "Uploading something..." );
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setProgress(0);
        pd.setMax(100);
        pd.show();
    }

    @Override
    protected void onProgressUpdate(Long... progress) {
        pd.setProgress( (int)( progress[0] * 100 / fileSize ) );
     }

    private int storeFile( OutputStream out, String local ) {
        try {
            InputStream in = new FileInputStream( local );

            byte[] buffer = new byte[ bufferSize * 1024 ];
            int read;
            int allRead = 0;
            while( ( ( read = in.read( buffer ) ) != - 1 ) && !isCanceling ) {
                allRead += read;
                this.publishProgress( (long) allRead );
                out.write( buffer, 0, read );
            }
            in.close();
            in = null;
            out.flush();
            out.close();
            out = null;
            return allRead;
        } catch( Throwable th ) {
            Log.d( "Error: ", th.getMessage() );
            return -1;
        }
    }

    @Override
    protected Boolean doInBackground( AFileDescriptor... params ) {
        ASubFileDescriptor file = params[0].getDefaultFile();
        FTPClient ftp = new FTPClient();
        try {
            ftp.connect( FTPHostName );
            ftp.login( FTPUser, FTPPass );
            ftp.cwd( FTPTargetFolder );

            ftp.enterLocalPassiveMode();

                            String storeName = file.getStoreName();
            ftp.setFileType( FTP.BINARY_FILE_TYPE );
            this.fileSize =  file.getFile().length();
            OutputStream out = ftp.storeFileStream( storeName );
            int bytes = storeFile( out,
                       file.getFile().getAbsolutePath() );

            ftp.logout();
            ftp.disconnect();
            return bytes > 0;
        } catch( Throwable th ) {
            Log.d( "FTP Error:", th.getMessage() );
            return false;
        }
    }

    @Override
    protected void onPostExecute( Boolean success ) {
        try {
            pd.dismiss();
        } catch( Throwable th ) {

        }

        if( success ) {
                        // do something
        } else {
                        // do something else
    }
}