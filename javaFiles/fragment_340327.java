public void readMails() {
        properties = new Properties();
        properties.setProperty("mail.host", "mail.etranssolutions.com"); 
        //properties.setProperty("mail.port", "110");
        properties.setProperty("mail.transport.protocol", "imap");
        session = Session.getInstance(properties,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(userName, password);
                    }
                });
        try {
            store = session.getStore("imap");
            ...... (Rest Of the Code As it is ... )