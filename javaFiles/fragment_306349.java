public class StringResponseDTO {
    private String redirect;
    private Map<String, String> errors;

    public StringResponseDTO(final String redirect) {
        this.redirect = redirect;
    }

    public StringResponseDTO(final Collection<? extends FieldError> errors) {
        this.errors =
                errors.stream()
                      .collect(Collectors.toMap(
                              FieldError::getField,
                              FieldError::getDefaultMessage
                      ));
    }

    public String getRedirect() {
        return redirect;
    }

    public Map<String, String> getErrors() {
        return errors;
    }
}