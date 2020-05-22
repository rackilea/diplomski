private void createLoginUI(final AbstractOrderedLayout parentLayout) {
final Rpi_gpio_controllerApplication application = this;

LoginForm loginForm = new LoginForm();
loginForm.addListener(new LoginForm.LoginListener() {
    Rpi_gpio_controllerApplication mApplication = application;

    @Override
    public void onLogin(LoginEvent event) {
        String loginErrorMessage = new User(
                new UserData(event.getLoginParameter("username"), event.getLoginParameter("password")),
                mApplication).login();
        if (loginErrorMessage != null) {
            Notification notification = new Notification(LoginErrorMessage, loginErrorMessage,
                    Notification.TYPE_ERROR_MESSAGE);
            notification.setDelayMsec(1000);
            notification.show(Page.getCurrent());
        }
    }
});

Panel loginPanel = new Panel("Log in!!!!");
loginPanel.setWidth("200px");
loginPanel.setHeight("250px");
loginPanel.setContent(loginForm);

parentLayout.addComponent(loginPanel);
parentLayout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);