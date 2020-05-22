String setLastName  =  "document.getElementsByName('lastName')[0].value='" + lastName + "';";
    String setName =  "document.getElementsByName('firstName')[0].value='" + name + "'";
    String setDateBirth = "document.getElementsByName('birthdate')[0].value='" + datebirth + "';";
    String setPhone = "document.getElementsByName('phone')[0].value='" + phone + "';";
    String setEmail = "document.getElementsByName('email')[0].value='" + email + "';";
    String setPassport = "document.getElementsByName('passport')[0].value='" + passport + "';";
    Button button = new Button("Fill the form");

    button.setOnAction(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent actionEvent) {
            webEngine.executeScript(setLastName);
            webEngine.executeScript(setName);
            webEngine.executeScript(setDateBirth);
            webEngine.executeScript(setPhone);
            webEngine.executeScript(setEmail);
            webEngine.executeScript(setPassport);
        }
    });