Authenticator authenticator = new Authenticator() {
        @Override
        public PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("user",
                    "mypassword".toCharArray());
        }
    };
    Authenticator.setDefault(authenticator);