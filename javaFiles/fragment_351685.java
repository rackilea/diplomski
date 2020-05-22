MimeMessage msg = new MimeMessage(session);
msg.setFrom(new InternetAddress(from));
MimeMultipart multipart = new MimeMultipart();
msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recipient));
MimeBodyPart tmpBp = new MimeBodyPart();
tmpBp.setContent(message,"text/plain; charset=utf-8");
multipart.addBodyPart(tmpBp);
msg.setContent(multipart);
Transport.send(msg);