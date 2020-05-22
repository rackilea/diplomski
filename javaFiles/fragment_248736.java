public class GMail {

    final String emailPort = "587";
    final String smtpAuth = "true";
    final String starttls = "true";
    final String emailHost = "smtp.gmail.com";

    String fromEmail;
    String fromPassword;
    @SuppressWarnings("rawtypes")
    String toEmailList;
    String emailSubject;
    String emailBody;
    String path;
    String attachmentName;
    Properties emailProperties;
    Session mailSession;
    MimeMessage emailMessage;

    public GMail() {

    }

    @SuppressWarnings("rawtypes")
    public GMail(String fromEmail, String fromPassword,
            String toEmailList, String emailSubject, String emailBody, String path, String attachmentName) {
        this.fromEmail = fromEmail;
        this.fromPassword = fromPassword;
        this.toEmailList = toEmailList;
        this.emailSubject = emailSubject;
        this.emailBody = emailBody;
        this.path = path;
        this.attachmentName = attachmentName;

        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", smtpAuth);
        emailProperties.put("mail.smtp.starttls.enable", starttls);

    }

    public MimeMessage createEmailMessage() throws AddressException,
            MessagingException, UnsupportedEncodingException {

        mailSession = Session.getDefaultInstance(emailProperties, null);
    emailMessage = new MimeMessage(mailSession);

    emailMessage.setFrom(new InternetAddress(fromEmail, fromEmail));

    Log.i("GMail", "toEmail: " + toEmailList);
    emailMessage.addRecipient(Message.RecipientType.TO,
            new InternetAddress(toEmailList));

    emailMessage.setSubject(emailSubject);
    MimeBodyPart messageBodyPart = new MimeBodyPart();
    Multipart multipart = new MimeMultipart();
    DataSource source = new FileDataSource(path);
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(attachmentName);
    multipart.addBodyPart(messageBodyPart);
    MimeBodyPart textBodyPart = new MimeBodyPart();
     textBodyPart.setText(emailBody);
     multipart.addBodyPart(textBodyPart);

    emailMessage.setContent(multipart);
        Log.i("GMail", "Email Message created.");
        return emailMessage;
    }

    public void sendEmail() throws AddressException, MessagingException {

        Transport transport = mailSession.getTransport("smtp");
        transport.connect(emailHost, fromEmail, fromPassword);
        Log.i("GMail", "allrecipients: " + emailMessage.getAllRecipients());
        transport.sendMessage(emailMessage, emailMessage.getAllRecipients());
        transport.close();
        Log.i("GMail", "Email sent successfully.");

    }

}