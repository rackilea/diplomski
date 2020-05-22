public void sendMail(String mailId,String outputFile) {

    final String username = "a@gmail.com";
    final String password = "MyPassowrd";

    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class",
            "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");

    Session session = Session.getDefaultInstance(props,
        new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username,password);
            }
        });

    try {

        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress("a@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(mailId));
        message.setSubject("MySubject");

        MimeBodyPart messageBodyPart =  new MimeBodyPart();
        messageBodyPart.setText("This is the mail content");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        messageBodyPart = new MimeBodyPart();
        DataSource source = 
          new FileDataSource(outputFile);
        messageBodyPart.setDataHandler(
          new DataHandler(source));
        messageBodyPart.setFileName("MyFile.pdf");
        multipart.addBodyPart(messageBodyPart);

        // Put parts in message
        message.setContent(multipart);

        Transport.send(message);

        System.out.println("Done");

    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }
}