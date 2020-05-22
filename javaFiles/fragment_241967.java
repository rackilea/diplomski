public class CustomException extends Exception {

    private String message;
    private Object model;

    public CustomException(String message, Object model) {
        super(message);
        this.model = model;
    }

    public Object getModel() {
        return model;
    }
}