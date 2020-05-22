Message message = new MimeMessage(Session.getInstance(System.getProperties()));

String email_subject = "subject";
message.setSubject(email_subject, "UTF-8");
message.setSentDate(new Date());

MimeBodyPart content = new MimeBodyPart();
String msg_body = "Message body";
content.setText("<p style=font-style:italic;font-size:20px>"+ msg_body +" </p>", "UTF-8", "html");
Multipart multipart = new MimeMultipart();
multipart.addBodyPart(content);

MimeBodyPart attachment = new MimeBodyPart();
attachment.attachFile(file);
multipart.addBodyPart(attachment);

message.setContent(multipart);
message.setFlags(new Flags(Flags.Flag.DRAFT), true);

OutputStream out = new FileOutputStream(fileName);
message.saveChanges();
message.writeTo(out);
out.close();