props.setProperty("mail.smtp.host", "smpt.host");
props.setProperty("mail.smtp.starttls.enable", "false");
props.setProperty("mail.smtp.port","25");
props.setProperty("mail.smtp.user", "alerts");
props.setProperty("mail.smtp.auth", "true");

Session session = Session.getDefaultInstance(props);
session.setDebug(true);

MimeMessage message = new MimeMessage(session);
message.setFrom(new InternetAddress("mail1@mail.es"));
message.addRecipient(Message.RecipientType.TO, new InternetAddress("mail2@mail.es"));
message.setSubject("Subject");
message.setText("Text");

Transport t = session.getTransport("smtp");
t.connect("user","pass");
t.sendMessage(message,message.getAllRecipients());
t.close();