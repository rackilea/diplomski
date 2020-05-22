Properties props = new Properties();
Session session = Session.getDefaultInstance(props, null);
try {
    Message msg = new MimeMessage(session);
    msg.setFrom(new InternetAddress("admin@domain.com", "Admin", "UTF-8"));
    msg.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientAddress));
    msg.setSubject(emailSubject);
    msg.setText(emailText);
    Transport.send(msg);

} catch (AddressException e) {
// TO address not valid
} catch (MessagingException e) {
    // other email error
} catch (UnsupportedEncodingException e) {
    // should not happen UTF-8 is always available
}