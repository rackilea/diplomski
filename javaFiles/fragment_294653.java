byte[] imageBytes = ((DataBufferByte) img.getData().getDataBuffer()).getData();

ByteArrayDataSource bds = new ByteArrayDataSource(imageBytes, "image/png"); 
messageBodyPart.setDataHandler(new DataHandler(bds)); 
messageBodyPart.setFileName("./phill.png");
messageBodyPart.setHeader("Content-ID", "<image>");
multipart.addBodyPart(messageBodyPart);