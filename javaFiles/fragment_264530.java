ContentResolver contentResolver;
contentResolver = this.getContentResolver();
uriPath=retrieveArchivedUri();
Uri tempUri;
Uri uri; 
String authority;
tempUri=Uri.parse(uriPath);
authority=retrieveArchivedAuthority();
uri= DocumentsContract.buildDocumentUri(authority,
            DocumentsContract.getDocumentId(tempUri)); //folder Uri

try 
{
 DocumentsContract.createDocument(contentResolver,uri,"plain/text","fileName");
} 
catch (FileNotFoundException e) 
{
        e.printStackTrace();
}