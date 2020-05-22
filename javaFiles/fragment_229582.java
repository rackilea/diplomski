public class MyHttpClientException extends Exception {
    private final int errorCode;

    public MyHttpClientException(final int errorCode) {
         this.errorCode = errorCode;
    }

    // rest of the constructors, one example:
    public MyHttpClientException(int errorCode, String message) {
         super(message);
         this.errorCode = errorCode;
    }

    public int getErrorCode{
        return errorCode;
    }
}