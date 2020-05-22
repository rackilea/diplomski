//Create session
        Properties props = System.getProperties();
        props.put("mail.smtp.user", user);
        props.put("mail.smtp.password", password);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", mailhost);
        props.put("mail.smtp.ssl.enable", "true");


        javax.mail.Authenticator auth = null;
        auth = new javax.mail.Authenticator() {
            @Override
            public javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(user, password);
            }
        };
        session = Session.getInstance(props, auth);
        //get transport object from session and connect to mail server
        Transport tr = session.getTransport("smtp");
        tr.connect(session.getProperty("mail.smtp.host"),  session.getProperty("mail.smtp.user"), session.getProperty("mail.smtp.password"));

        //create message  and set from,recipients,content and other stuff here on the message object.
        Message msg = new MimeMessage(session);
       //..................
       //...................

       //Save and send the message
        msg.saveChanges();
        tr.sendMessage(msg, msg.getAllRecipients());
        tr.close();