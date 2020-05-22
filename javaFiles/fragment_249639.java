Session session = Session.getInstance(props,
  new javax.mail.Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, username);
    }
  });

session = Session.getInstance(props, this); // this is the local variable not the instance one