public class ApplicationException extends RuntimeException {

   public ApplicationException(Exception cause) {
       super(cause);
   }

   ...
}