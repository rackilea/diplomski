MimeMessage message = new MimeMessage(session);
  DataHandler handler = new DataHandler(new ByteArrayDataSource(body.getBytes(), "text/plain"));
  message.setSender(new InternetAddress(sender));
  message.setSubject(subject);
  message.setDataHandler(handler);
  message.setRecipient(Message.RecipientType.TO, new InternetAddress(recipients));
  Transport.send(message);