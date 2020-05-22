public static void createMessage(String to, String from, String subject, String body, List<File> attachments) {
try {
    Message message = new MimeMessage(Session.getInstance(System.getProperties()));
    message.setFrom(new InternetAddress(from));
    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
    message.setSubject(subject);

    //make it a draft!!             
    message.setHeader("X-Unsent", "1");

    // create the message part 
    MimeBodyPart content = new MimeBodyPart();
    // fill message
    content.setText(body);
    Multipart multipart = new MimeMultipart();
    multipart.addBodyPart(content);
    // add attachments
    for(File file : attachments) {
        MimeBodyPart attachment = new MimeBodyPart();
        DataSource source = new FileDataSource(file);
        attachment.setDataHandler(new DataHandler(source));
        attachment.setFileName(file.getName());
        multipart.addBodyPart(attachment);
    }
    // integration
    message.setContent(multipart);
    // store file
    message.writeTo(new FileOutputStream(new File("c:/mail.eml")));
} catch (MessagingException ex) {
    Logger.getLogger(Mailkit.class.getName()).log(Level.SEVERE, null, ex);
} catch (IOException ex) {
    Logger.getLogger(Mailkit.class.getName()).log(Level.SEVERE, null, ex);
}
}