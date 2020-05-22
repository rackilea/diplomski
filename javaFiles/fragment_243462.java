public class Response<T> {

    private boolean success;
    private String message;
    private T result;

    public T getResult() {
        return result;
    }

    public String getMessage () {
       return message;
    }

    public boolean getSuccess() {
        return success;
    }
}