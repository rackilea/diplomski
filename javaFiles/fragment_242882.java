public class SendMail {
    String host, port, emailid,username, password;
    Properties props = System.getProperties();
    Session l_session = null;

    public SendMail() {
        host = "smtp.mail.yahoo.com";
        port = "465";
        emailid = "...@yahoo.com";
        username = "...";
        password = "pwd";

        emailSettings();
        createSession();
        sendMessage("...@yahoo.com", "xyz@gmail.com","Test subject","Test mail with some random text");
    }

    public void emailSettings() {
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.auth", "true");
        props.put("mail.debug", "false");
        props.put("mail.smtp.port", port);
    }

    public void createSession() {
        l_session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
        l_session.setDebug(true);
    }

    public boolean sendMessage(String emailFromUser, String toEmail, String subject, String messageText) {
        try {
            MimeMessage message = new MimeMessage(l_session);
            emailid = emailFromUser;
            message.setFrom(new InternetAddress(this.emailid));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.addRecipient(Message.RecipientType.BCC, new InternetAddress(toEmail));
            message.setSubject(subject);
            message.setContent(messageText, "text/html");

            Transport.send(message);
            System.out.println("An email has been sent");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}