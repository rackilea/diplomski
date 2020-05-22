@InitBinder
private void initBinder(WebDataBinder binder) {
    // binder.setDisallowedFields("property1");
    binder.registerCustomEditor(String.class, "somefield", new PropertyEditorSupport() {
        @Override
        public void setValue(Object value) {
            throw new IllegalStateException();
        }
    });
}