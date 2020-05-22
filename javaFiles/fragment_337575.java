public static class MyFileNameMap implements FileNameMap
{
    private FileNameMap delegate = URLConnection.getFileNameMap();

    @Override
    public String getContentTypeFor( String fileName )
    {
        String contentType = delegate.getContentTypeFor( fileName );
        if( "application/octet-stream".equals( contentType ) )
        {
            // Sun's java classifies zip and gzip as application/octet-stream,
            // which VFS then uses, instead of looking at its extension
            // map for a more specific mime type
            return null;
        }
        return contentType;
    }
}