MimeBodyPart attachmentPart = new MimeBodyPart();
FileDataSource fileDataSource = new FileDataSource(filename) {
  @Override
 public String getContentType() {
      return "application/octet-stream";
        }
};
attachmentPart.setDataHandler(new DataHandler(fileDataSource));