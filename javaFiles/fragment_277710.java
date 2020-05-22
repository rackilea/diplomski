XspDiv cont = new XspDiv();
cont.setId("loginFormContainer");
cont.setStyleClass("loginFormContainer");
XspInputText userName = new XspInputText();
userName.setId("userNameInputId");
Attr placeHolderAttr = new Attr();
placeHolderAttr.setComponent(userName);
placeHolderAttr.setName("placeholder");
placeHolderAttr.setValue("Enter your Username");
userName.addAttr(attr);

XspInputText password = new XspInputText();
password.setId("passwordInputId");
password.setPassword(true);
//NOTE: I can't get the placeholder attr to work on a password field but
//you can try as your mileage may vary

cont.getChildren().add(userName);
cont.getChildren().add(password);
this.getChildren().add(cont);