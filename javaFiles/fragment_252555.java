@Override
protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {  // or @InitBinde
    binder.registerCustomEditor(User.class, "user", new PropertyEditorSupport() {
        @Override
        public void setAsText(String text) {
            User user = new User(text); // Some kind of initialization of your object from string
            setValue(user);
        }

        @Override
        public String getAsText() {
            User user = getValue();
            return user.getId(); // Some kind of string from your User object
        }
    });
}