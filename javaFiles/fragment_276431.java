Session session = Session.getDefaultInstance(props,
    new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("someUserName", "somePassword");
        }
    }
);