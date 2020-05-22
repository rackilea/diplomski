public abstract class Data {
   public abstract String read() throws DataUnavailableException;
}

class DataFile extends Data { 
    public String read() throws DataUnavailableException {
        if( !this.file.exits() ) {
            throw new DataUnavailableException( "Cannot read from ", file );
         }

         try { 
              ....
         } catch( IOException ioe ) { 
             throw new DataUnavailableException( ioe );
         } finally {
              ...
         }
 }


class DataMemory extends Data { 
    public String read()  {
        // Everything is performed in memory. No exception expected.
    }
 }

 class DataWebService extends Data { 
      public string read() throws DataUnavailableException {
           // connect to some internet service
           try {
              ...
           } catch( UnknownHostException uhe ) {
              throw new DataUnavailableException( uhe );
           }
      }
 }