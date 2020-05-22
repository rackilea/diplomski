BodyPart messageBodyPart = new MimeBodyPart();
          String htmlText = "<H1>Hello</H1><img src=\"cid:image\">";
          messageBodyPart.setContent(htmlText, "text/html");
          // add it
         MimeMultipart multipart = new MimeMultipart("related");

         multipart.addBodyPart(messageBodyPart);

        // second part (the image)
          messageBodyPart = new MimeBodyPart();

          java.io.InputStream inputStream = this.getClass().getResourceAsStream("/HappyBirthday.JPG");
         ByteArrayDataSource ds = new ByteArrayDataSource(inputStream, "image/jpg");
         System.out.println(inputStream);

          messageBodyPart.setDataHandler(new DataHandler(ds));
          messageBodyPart.setHeader("Content-ID", "<image>");

          messageBodyPart.setDisposition(MimeBodyPart.INLINE);

         multipart.addBodyPart(messageBodyPart);
         message.setContent(multipart);  
         // Send message
         Transport.send(message);