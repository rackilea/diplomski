@Override protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
attributes.getAjaxCallListeners().add(new AjaxCallListener() {
        @Override public CharSequence getPrecondition(Component component) {
            return "return isPropagationAllowed()";
        }
    });
}