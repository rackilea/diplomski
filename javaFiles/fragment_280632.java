public class ZipAndEmail {
  public static void main(String args[]) {
    String host = args[0];
    String from = args[1];
    String to = args[2];

    //Assuming you already have this list of file names
    String[] filenames = new String[]{"filename1", "filename2"};

    try {
      byte[] buf = new byte[1024];
      String zipFilename = "outfile.zip";
      ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFilename));

      for (int i=0; i<filenames.length; i++) {
        FileInputStream in = new FileInputStream(filenames[i]);
        out.putNextEntry(new ZipEntry(filenames[i]));
        int len;
        while ((len = in.read(buf)) > 0) {
          out.write(buf, 0, len);
        }
        out.closeEntry();
        in.close();
      }
      out.close();


      Properties props = System.getProperties();
      props.put("mail.smtp.host", host);
      Session session = Session.getDefaultInstance(props, null);

      // Define message
      MimeMessage message = new MimeMessage(session);
      message.setFrom(new InternetAddress(from));
      message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
      message.setSubject("Your Zip File is Attached");

      MimeBodyPart messageBodyPart = new MimeBodyPart();
      messageBodyPart.setText("Your zip file is attached");
      Multipart multipart = new MimeMultipart();
      multipart.addBodyPart(messageBodyPart);

      // Part two is attachment
      messageBodyPart = new MimeBodyPart();
      DataSource source = new FileDataSource(zipFilename);
      messageBodyPart.setDataHandler(new DataHandler(source));
      messageBodyPart.setFileName(zipFilename);
      multipart.addBodyPart(messageBodyPart);

      // Put parts in message
      message.setContent(multipart);

      // Send the message
      Transport.send( message );

      // Finally delete the zip file
      File f = new File(zipFilename);
      f.delete();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}