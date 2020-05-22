Button button = new Button() {
    @Override
    public void attach() {
        ResourceBundle bundle = ResourceBundle.getBundle(Translation_portletApplication.class.getName(), user.getLocale());
        setCaption(bundle.getString("first_name"));
    }
};
window.addComponent(button);