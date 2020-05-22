public void yahooSend(String mail,String subject,String msg) {

        // Sender's email ID needs to be mentioned
         String from = "YOUR_YAHOO_MAIL";
         String pass ="YOUR_YAHOO_PASSWORD";
        // Recipient's email ID needs to be mentioned.
       String to = mail;
       String host = "smtp.mail.yahoo.com";

       // Get system properties
       Properties properties = System.getProperties();
       // Setup mail server
       properties.put("mail.smtp.starttls.enable", "true");
       properties.put("mail.smtp.host", host);
       properties.put("mail.smtp.user", from);
       properties.put("mail.smtp.password", pass);
      // props.put("mail.smtp.user", "YAHOO_USER_NAME"); 
       properties.put("mail.smtp.port", "587");
       properties.put("mail.smtp.auth", "true");


       // Get the default Session object.
       Session session = Session.getDefaultInstance(properties);

       try{
          // Create a default MimeMessage object.
          MimeMessage message = new MimeMessage(session);

          // Set From: header field of the header.
          message.setFrom(new InternetAddress(from));

          // Set To: header field of the header.
          message.addRecipient(Message.RecipientType.TO,
                                   new InternetAddress(to));

          // Set Subject: header field
          message.setSubject(subject);

          // Now set the actual message
          message.setText(msg);
          System.out.print("Sending msg "+msg);
          // Send message
          Transport transport = session.getTransport("smtp");
          transport.connect(host,587, from, pass);
          transport.sendMessage(message, message.getAllRecipients());
          transport.close();
         System. out.println("Sent message successfully....");
       }catch (MessagingException mex) {
           System. out.print(mex);
          mex.printStackTrace();
       }
 }