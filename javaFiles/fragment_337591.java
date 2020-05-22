public class RestErrorDTO extends RestWrapperDTO {
    private Map<String, String> errors;

    public Map<String, String> getErrors() {
        return errors;
    }
    public void setErrors(Map<String, String> value) {
        errors = value
    }
}