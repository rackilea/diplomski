Properties properties = System.getProperties();
    properties.put("mail.smtp.host", server);
    properties.put("mail.smtp.port", "" + port);

    Session session = Session.getInstance(properties);
    Transport transport = session.getTransport("smtp");

    transport.connect(server, username, password);

    for (int i = 0; i < count; i++) {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(from));
        InternetAddress[] address = {new InternetAddress(to)};
        message.setRecipients(Message.RecipientType.TO, address);

        message.setSubject(subject + "JavaMail API");
        message.setSentDate(new Date());

        setHTMLContent(message);
        message.saveChanges();
        transport.sendMessage(message, address);

    }

    transport.close();