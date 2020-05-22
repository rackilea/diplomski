MyAuthenticator authenticator = new MyAuthenticator();

Properties properties = new Properties();
properties.setProperty("mail.smtp.submitter",
                        authenticator.getPasswordAuthentication().getUserName());
properties.setProperty("mail.smtp.auth", "true");

Session session = Session.getInstance(properties, authenticator);