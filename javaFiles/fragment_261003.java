Multipart multipart = new MimeMultipart("mixed");
for (String str : attachment_PathList) {
    MimeBodyPart messageBodyPart = new MimeBodyPart();
    DataSource source = new FileDataSource(str);
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(source.getName());
    multipart.addBodyPart(messageBodyPart);
}
msg.setContent(multipart);
Transport.send(msg);