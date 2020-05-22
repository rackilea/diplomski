MimeBodyPart attachmentPart = new MimeBodyPart();

try {
  DataSource ds = new ByteArrayDataSource(attachment.getBytes("UTF-8"), "application/octet-stream");
  attachmentPart = new MimeBodyPart();
  attachmentPart.setDataHandler(new DataHandler(ds));
} 
catch (Exception e) {
  Logger.getLogger("Blina").log(Level.SEVERE, Misc.getStackTrace(e));
}

attachmentPart.setFileName(fileName);
multipart.addBodyPart(attachmentPart);

// Put parts in message
msg.setContent(multipart);