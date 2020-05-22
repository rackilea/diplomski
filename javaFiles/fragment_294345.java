loginButton.setOnAction(new EventHandler<ActionEvent>() {
                        @Override
                        public void handle(ActionEvent e) {
                            if(userLogged) 
                              doLogout();
                            else
                              doLogin();

                        }
});