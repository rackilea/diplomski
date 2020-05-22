public class ErrorDTO {

    private String code;
    private String message;
    private String field;
    private Object rejectedValue;

    public ErrorDTO() {

    }

    public ErrorDTO(String code, String message) {
        this(code, message, null, null);
    }

    public ErrorDTO(String code, String message, String field, Object rejectedValue) {
        this.code = code;
        this.message = message;
        this.field = field;
        this.rejectedValue = rejectedValue;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getRejectedValue() {
        return rejectedValue;
    }

    public void setRejectedValue(Object rejectedValue) {
        this.rejectedValue = rejectedValue;
    }

}