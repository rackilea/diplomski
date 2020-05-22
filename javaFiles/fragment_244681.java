import java.util.EventObject;

public class SomethingHappenedEvent extends EventObject{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String message;

    public SomethingHappenedEvent(Object source, String message) {
        super(source);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}