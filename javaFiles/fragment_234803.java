public class PathTokenNotFoundException extends AuthenticationException {

   public PathTokenNotFoundException(String msg) {
       super(msg);
    }

    public PathTokenNotFoundException(String msg, Throwable t) {
       super(msg, t);
    }
}