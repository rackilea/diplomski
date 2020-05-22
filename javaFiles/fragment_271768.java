public static class ErrorBean{
    private int code;
    private String message;
    private List<ValidationFailureDto> failures;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<ValidationFailureDto> getFailures() {
        return failures;
    }
    public void setFailures(List<ValidationFailureDto> failures) {
        this.failures = failures;
    }
}