try {
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("sender@emailID.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress("recepint@emailID.com"));
        message.setSubject("Hello iCal4j Meeting Invitation");

        // create the message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();

        // fill message
        messageBodyPart.setText("Hi Sir, Please see the demo example to send meeting invitaiton from iCal4j API.");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // Part two is attachment
        messageBodyPart = new MimeBodyPart();
        DataSource source = new FileDataSource(calFile);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(calFile);
        multipart.addBodyPart(messageBodyPart);

        // Put parts in message
        message.setContent(multipart);

        Transport.send(message);
    //  System.out.println(meeting);

    } catch (MessagingException e) {
        throw new RuntimeException(e);
    }