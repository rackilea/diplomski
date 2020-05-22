String from = "JohnDoe@gmail.com";
    String pass = "***********";
    String[] to = { "JohnDoe@gmail.com" }; // list of recipient email addresses
    String subject = "Subject Line";

    Properties props = System.getProperties();
    String host = "smtp.gmail.com";
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", host);
    props.put("mail.smtp.user", from);
    props.put("mail.smtp.password", pass);
    props.put("mail.smtp.port", "587");
    props.put("mail.smtp.auth", "true");

    Session session = Session.getDefaultInstance(props);
    MimeMessage message = new MimeMessage(session);

    try {
        message.setFrom(new InternetAddress(from));
        InternetAddress[] toAddress = new InternetAddress[to.length];

        // To get the array of addresses
        for( int i = 0; i < to.length; i++ ) {
            toAddress[i] = new InternetAddress(to[i]);
        }

        for( int i = 0; i < toAddress.length; i++) {
            message.addRecipient(Message.RecipientType.TO, toAddress[i]);
        }

       BodyPart messageBodyPart = new MimeBodyPart();

     // Now set the actual message
     messageBodyPart.setText("");

     // Create a multipar message
     Multipart multipart = new MimeMultipart();

     // Set text message part
     multipart.addBodyPart(messageBodyPart);

     // Part two is attachment
     messageBodyPart = new MimeBodyPart();
     String filename = "send.jpeg";
     DataSource source = new FileDataSource(filename);
     messageBodyPart.setDataHandler(new DataHandler(source));
     messageBodyPart.setFileName(filename);
     multipart.addBodyPart(messageBodyPart);
     message.setContent(multipart);

     message.setSubject(subject);
     Transport transport = session.getTransport("smtp");
     transport.connect(host, from, pass);
     transport.sendMessage(message, message.getAllRecipients());
     transport.close();
    }
    catch (AddressException ae) {
        ae.printStackTrace();
    }
    catch (MessagingException me) {
        me.printStackTrace();
    }