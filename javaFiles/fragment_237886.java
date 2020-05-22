MimeMessage message = new MimeMessage(session);

 // create the message part 
  MimeBodyPart messageBodyPart = new MimeBodyPart();

 //fill message
  messageBodyPart.setText("Hi");

   Multipart multipart = new MimeMultipart();
   multipart.addBodyPart(messageBodyPart);

// Part two is attachment
messageBodyPart = new MimeBodyPart();
DataSource source =  new FileDataSource(fileAttachment); // your file
messageBodyPart.setDataHandler( new DataHandler(source));
messageBodyPart.setFileName(fileAttachment);
multipart.addBodyPart(messageBodyPart);

// Put parts in message
message.setContent(multipart);

// Send the message
Transport.send( message );