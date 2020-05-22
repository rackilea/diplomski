Panel username = new Panel(new Border.Invisible(), Panel.Orientation.HORISONTAL);
username.addComponent(new Label("Username: "));
TextBox userBox = new TextBox(null, 15);
username.addComponent(userBox);
addComponent(username);
// ... and later elsewhere 
usernameIn = userBox.getText();