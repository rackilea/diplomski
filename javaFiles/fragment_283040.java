@SuppressWarnings("serial")
public static class MyJsonProcessingException extends JsonProcessingException {
    protected MyJsonProcessingException(String msg) {
        super(msg);
    }
}