Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.outlook.com");
        props.put("mail.smtp.starttls.enable", "true");
        Session session = Session.getInstance(props, null);
        InputStream is = new FileInputStream(mail.getAbsoluteFile());
        MimeMessage msg = new MimeMessage(session, is);
        msg.setFrom(new InternetAddress("someoneelse@example.org"));;
        msg.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(receiver, false));
        msg.setSubject(subject);
        msg.setHeader("X-Mailer", "Email program");
        msg.setSentDate(new Date());
        Transport.send(msg, "someone@example.org", "1234");