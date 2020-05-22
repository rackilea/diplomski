authentication = new PasswordAuthentication(user, *pass*);//You must hand it username and pass, not two usernames like before
    Properties props = new Properties();
    props.put("mail.user", user);
    props.put("mail.host", host);
    props.put("mail.debug", debug ? "true" : "false");
    props.put("mail.store.protocol", pop3Provider);//an example provider is pop.gmail.com, or I think aol is pop.aol.com, many follow that pattern, this is used for reading inbox/incoming messages (hence the store)
    props.put("mail.transport.protocol", smtpProvider);//follows same as above, but smtp not pop, this is used for outgoing messages (hence the transport)
    session = Session.getDefaultInstance(props);