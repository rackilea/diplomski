final LoginDialog dialog = new LoginDialog();
    dialog.addLoginListener(new LoginListener() {

        @Override
        public void handleLoginEvent(LoginEvent evt) {
            if(evt.getId() == LoginEvent.LOGIN_SUCCEEDED {
                dialog.close();
                //continue execution
                return;
            }
            if(evt.getId() == LoginEvent.LOGIN_FAILED) {
                JOptionPane.showMessageDialog(null, "Login failed!");
                return;
            }
            if(evt.getId() == LoginEvent.CLOSE_LOGIN_DIALOG) {
                dialog.close();
                // do something when this dialog is closed
            }                
        }
    };
    dialog.show();