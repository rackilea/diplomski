@Override
public void init() {
    Window mainWindow = new Window("LoginApplication");

    Label label = new Label("Hello anonymous Vaadin user");
    if (getUser() != null) {
        // user has logged in
        label = new Label("Hello " + ((User) getUser()).getFullName() + ", language id is '" + user.getLanguageId() + "'");
    }
    mainWindow.addComponent(label);
    setMainWindow(mainWindow);
}