public String unzipStream( String sFileName ) 
{ 
    ByteArrayOutputStream oBaosBuffer = new ByteArrayOutputStream(); 
    try  
    { 
      ZipInputStream oZipStream = new ZipInputStream( this.activity.getAssets().open( sFileName ) ); 
      ZipEntry oZipEntry;
      long iSize = 0;

      while( (iSize == 0) && ((oZipEntry = oZipStream.getNextEntry()) != null) && !oZipEntry.isDirectory() ) 
      {
           iSize = IOUtils.copyLarge(oZipStream, oBaosBuffer);
           oZipStream.closeEntry(); 
      } 

      oZipStream.close(); 

      if( iSize > 0 )
      {
        return oBaosBuffer.toString("UTF-8");
        //sResult = new String( Base64.decode(sb.toString("UTF-8"), Base64.DEFAULT), Charset.forName("UTF-8") );
      }
    } 
    catch(Exception e) 
    { 
         System.out.println("Error unzip: "+e.getMessage());
    } 

    return null;
}