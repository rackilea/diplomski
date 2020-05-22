yourField.addValidator(new Validator<String>() {

  @Override
  public List<EditorError> validate(Editor<String> editor, String value) {
    final List<EditorError> errors = new ArrayList<EditorError>();
    if (!value.equals("test")) {
      errors.add(new DefaultEditorError(yourField, "Value is not \"test\"", value));
    }
    return errors;
  }
});