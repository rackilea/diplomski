Properties props = new Properties();
    props.setProperty("mail.transport.protocol", "smtp");
    Session mailSession = Session.getDefaultInstance(props, null);
    Transport transport = mailSession.getTransport("smtp");
    transport.connect("localhost", 25, null, null);

    Email email = new SimpleEmail();
    email.setFrom("example@example.com");
    email.addTo("example@example.com");
    email.setSubject("Hello Example");
    email.setMsg("Hello Example");
    email.setHostName("localhost"); // buildMimeMessage call below freaks out without this

    // dug into the internals of commons email
    // basically send() is buildMimeMessage() + Transport.send(message)
    // so rather than using Transport, reuse the one that I already have
    email.buildMimeMessage();
    Message m = email.getMimeMessage();
    transport.sendMessage(m, m.getAllRecipients());