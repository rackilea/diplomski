protected static Uri createUriFromPhotoIntentForHtcDesireHD( Activity activity, Intent intent, Uri uri ) {
    FileOutputStream fos = null;
    try {
        Bitmap bitmap = (Bitmap) intent.getExtras().get( "data" );
        File outputDir = activity.getCacheDir();
        File outputFile = File.createTempFile( "Photo-", ".jpg", outputDir );
        fos = new FileOutputStream( outputFile );
        bitmap.compress( Bitmap.CompressFormat.JPEG, 90, fos );
        uri = Uri.fromFile( outputFile );
    } catch ( IOException e ) {
        Ln.e( e, "Error creating temp file for HTC Desire HD" );
    } finally {
        try {
            if ( fos != null ) {
                fos.close();
            }
        } catch ( IOException e ) {
            Ln.e( e, "Error closing temp file for HTC Desire HD" );
        }
    }
    return uri;
}