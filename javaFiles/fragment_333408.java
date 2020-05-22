messageBodyPart = new MimeBodyPart();
DataSource fds1 = new FileDataSource(filepath + "b1.jpg");
messageBodyPart.setDataHandler(new DataHandler(fds1));
messageBodyPart.setHeader("Content-ID", "<image1>");
messageBodyPart.setFileName(filepath + "b1.jpg");            // <= HERE
multipart.addBodyPart(messageBodyPart);