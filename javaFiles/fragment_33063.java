properties.put("mail.smtp.auth", "true");
Authenticator authenticator = new Authenticator() {
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication("yourusername", "yourpassword");
    }
};