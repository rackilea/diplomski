public void wget( String urlstring, File destFile ) throws IOException {
  BufferedInputStream bis = new URL( urlstring ).openStream() ;
  BufferedOutputStream fos = new BufferedOutputStream( new FileOutputStream( destFile ) ) ;
  try {
    byte[] buffer = new byte[ 8192 ] ;
    int cnt = 0 ;
    while( ( cnt = bis.read( buffer, 0, 8192 ) ) > -1 ) {
      fos.write( buffer, 0, 8192 ) ;
    }
  }
  finally {
    bis.close() ;
    fos.close() ;
  }
}