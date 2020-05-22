Panel username = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
username.addComponent(new Label("Username: "));
TextBox userBox = new TextBox(null, 15);
userBox.addComponentListener(new ComponentListener() {
    void onComponentValueChanged(InteractableComponent component) {
         usernameIn = ((TextBox)component).getText();
    }
});

username.addComponent(userBox);
addComponent(username);