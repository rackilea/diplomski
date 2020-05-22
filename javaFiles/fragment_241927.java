Multipart mp = new MimeMultipart();
            Message message = new MimeMessage(session);
            MimeBodyPart mbp1 = new MimeBodyPart();
            MimeBodyPart mbp2 = new MimeBodyPart();
            message.setFrom(new InternetAddress("email"));
            message.setRecipients(Message.RecipientType.TO,
            InternetAddress.parse(toEmail));
            mbp1.setText(text);
                    mp.addBodyPart(mbp1);

            DataSource source = new FileDataSource(new File("screenshot location/hello-world.png"));
                mbp2.setDataHandler(new DataHandler(source));
                mbp2.setFileName("Screenshot.png");
                mbp2.setHeader("Content-ID", "<image_cid>");
            mp.addBodyPart(mbp2);

            message.setContent(mp);
            Transport.send(message);