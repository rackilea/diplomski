Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication("from", "password");
                    }
                });
Message message = new MimeMessage(session);
message.setFrom(new InternetAddress(creds.getFrom()));
message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("to"));
message.setSubject("subject");
message.setText("Java EE 7 is cool!");
Transport.send(message, message.getAllRecipients());