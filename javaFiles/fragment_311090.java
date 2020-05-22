public static void main(String[] args) {
    Properties props = new Properties();
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.socketFactory.port", "465");
    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.port", "465");
    Session session = Session.getDefaultInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("gmailUser", "*****");
                }
            });

    System.out.println(props);
    try {
        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("yourAddress@gmail.com"));
        message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse("arunGupta@oracle.com"));
        message.setSubject("Java EE7 jars deployed used on Java SE");
        message.setText("Dear Mr. Gupta,\nThank you for your work on Java EE7, but I need to send email from my desktop app.");
        Transport.send(message);
        System.out.println("Done");
    } catch (MessagingException utoh) {
        System.out.println("Error sending message:" + utoh.toString());
    }
}