private final InputStream getInputStreamFrom( File f ) {

      if( f == null && !f.exists() ) { 
          return NullInputStream.instance;
      }

      return new InputStream( new FileInputStream( f ) );

 }


 class NulllInputStream extends InputStream {

      private final static NullInputStream instance = new NullInputStream();

      private NullInputStream() {
      }

      public int read() { 
          return -1; 
      }
      .... other relevant methods here... 
 }