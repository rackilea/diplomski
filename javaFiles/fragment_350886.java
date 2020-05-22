public class MyBAIsWrapper implements InputStream {

   private ByteArrayInputStream wrapped;

   public MyBAIsWrapper(byte[] data) {
       wrapped=new ByteArrayInputStream(data);
   }

   //added method to refresh with new data
   public void renew(byte[] newData) {
       wrapped=new ByteArrayInpurStream(newData);
   }

   //implement the InputStreamMethods calling the corresponding methos on wrapped
   public int read() throws IOException {
      return wrapped.read();
   }

   public int read(byte[] b) throws IOException {
       return wrapped.read(b);
   }

   //and so on

}