accept.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // validate login data
            if(loginValid) {
                dispatchLoginEvent(new LoginEvent(dialog, LoginEvent.LOGIN_SUCCEEDED));
            } else {
                dispatchLoginEvent(new LoginEvent(dialog, LoginEvent.LOGIN_FAILED));
            }
        }
    });

    cancel.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispatchLoginEvent(new LoginEvent(dialog, LoginEvent.LOGIN_DIALOG_CLOSED));
        }
    });