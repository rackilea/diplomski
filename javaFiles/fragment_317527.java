public class SendEmail {

    public SendEmail () {}

    public void send (String text){
        String host = "smtp.gmail.com";
        String username = "user@email.com";
        String password = "password";
        Properties props = new Properties();
        // set any needed mail.smtps.* properties here
        Session session = Session.getInstance(props, new GMailAuthenticator("user", "password"));
        Message msg = new MimeMessage(session);
        Transport t;
        try {
            msg.setText(text);
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress("stackkinggame@gmail.com", "Stack King"));
            t = session.getTransport("smtps");
            t.connect(host, username, password);
            t.sendMessage(msg, msg.getAllRecipients());
            t.close();
            Gdx.app.log("Email", "Message sent successfully.");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    class GMailAuthenticator extends Authenticator {
        String user;
        String pw;
        public GMailAuthenticator (String username, String password)
        {
            super();
            this.user = username;
            this.pw = password;
        }
        public PasswordAuthentication getPasswordAuthentication()
        {
            return new PasswordAuthentication(user, pw);
        }
    }
}