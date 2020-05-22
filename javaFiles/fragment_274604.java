public int sendMail(String reciever_email, String subject, String body) {
    final String username = "YOUR USER EMAIL";
    final String password = "PASSWORD";
    Properties props = new Properties();
    props.put("mail.smtp.user", username);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "25");
    props.put("mail.debug", "true");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.EnableSSL.enable", "true");
    props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.setProperty("mail.smtp.socketFactory.fallbac k", "false");
    props.setProperty("mail.smtp.port", "465");
    props.setProperty("mail.smtp.socketFactory.port", "465");
    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
        protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
        }
    });

    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(reciever_email));
        message.setSubject(subject);
        message.setText(body);
        Multipart multipart = new MimeMultipart("related");
        BodyPart htmlPart = new MimeBodyPart();
        htmlPart.setContent("<html>HELLO</html>", "text/html");

        multipart.addBodyPart(htmlPart);
        message.setContent(multipart);
        Transport.send(message);
        return 1;
    } catch (Exception e) {
        return 0;

    }
}