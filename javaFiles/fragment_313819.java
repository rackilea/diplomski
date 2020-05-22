// oh, please-oh-please, change Download to filesToDownload
for( String aFile : Download ) {
    downloadFile( aFile );
}

private void downloadFile( String whichFile ) {
    System.out.println( "Downloading Poster: " + whichFile );
    new DownloadFileFromURL2().execute( file_url2 + whichFile );
}               


class DownloadFileFromURL2 extends AsyncTask<String, String, String> {
    ...

@Override
protected String doInBackground( String... url ) {

    System.out.println("Downloading Poster: " + url[0] );

    ...