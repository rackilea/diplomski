import com.fasterxml.jackson.core.JsonProcessingException;

public class MyException extends JsonProcessingException {
    public MyException(String message) {
        super(message);
    }
}