if(!attachment.equals("") && !attachment.isEmpty()) {
        BodyPart messageBodyPart = new MimeBodyPart()
        messageBodyPart.setContent(message,"text/html")
        Multipart multipart = new MimeMultipart()
        multipart.addBodyPart(messageBodyPart)

        messageBodyPart = new MimeBodyPart()
        messageBodyPart.attachFile(attachment)
        multipart.addBodyPart(messageBodyPart)              
        // Send the complete message parts
        msg.setContent(multipart)
    } 
    else {
        msg.setContent(message, "text/html")
    }