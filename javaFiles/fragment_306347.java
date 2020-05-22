public class StringResponseDTO {
    private String redirect;
    private TreeNode errors;

    public StringResponseDTO(final String redirect) {
        this.redirect = redirect;
    }

    public StringResponseDTO(final Collection<? extends FieldError> errors) {
        this.errors =
                errors.stream()
                      .collect(Collector.of(
                              objectMapper::createObjectNode,
                              (json, e) -> json.put(e.getField(), e.getDefaultMessage()),
                              (json, toMerge) -> {
                                  json.setAll(toMerge);
                                  return json;
                              }
                      ));
    }

    public String getRedirect() {
        return redirect;
    }

    public TreeNode getErrors() {
        return errors;
    }
}