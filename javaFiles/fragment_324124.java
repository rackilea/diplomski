MimeMessage message = new MimeMessage(Email.getSession()); 
message.setFrom(new InternetAddress("support@jthink.net"));
message.addRecipient(Message.RecipientType.TO, new InternetAddress(to, true));
message.setSubject(subject);
message.setContent(msg, "text/html; charset=utf-8");
message.saveChanges();
Transport.send(message);