MimeMessage message = new MimeMessage(session);
transport = mailSession.getNewTransport(session);
String to = "mail1@gmail.com , mail2@gmail.com, mail3@gmail.com";
InternetAddress[] parse = InternetAddress.parse(to , true);
message.setRecipients(javax.mail.Message.RecipientType.TO,  parse);
transport.send(message);