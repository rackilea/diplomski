EventHandler<ActionEvent> loginHandler = e -> {
    // handle login here...
};

usernameTextField.setOnAction(loginHandler);
loginBtn.setOnAction(loginHandler);