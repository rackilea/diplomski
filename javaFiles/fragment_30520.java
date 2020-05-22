Part attachment = new MimeBodyPart();
URL url = new URL("http://site/some-file.pdf");
URLDataSource uds = new URLDataSource(url);
attachment.setDataHandler(new DataHandler(uds));
attachment.setDisposition(Part.ATTACHMENT);
attachment.setFileName(url.getFile());