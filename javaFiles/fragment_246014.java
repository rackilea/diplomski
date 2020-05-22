String[] folders = path.split( "/" );
for ( String folder : folders ) {
    if ( folder.length() > 0 ) {
        try {
            sftp.cd( folder );
        }
        catch ( SftpException e ) {
            sftp.mkdir( folder );
            sftp.cd( folder );
        }
    }
}