public void attachFile(File file, Multipart multipart, MimeBodyPart messageBodyPart) {
    DataSource source = new FileDataSource(file);
    messageBodyPart.setDataHandler(new DataHandler(source));
    messageBodyPart.setFileName(file.getName());
    multipart.addBodyPart(messageBodyPart);    
}