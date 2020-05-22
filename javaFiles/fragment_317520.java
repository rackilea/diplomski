Multipart multiPart = (Multipart) message.getContent();

for (int i = 0; i < multiPart.getCount(); i++) {
    MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(i);
    if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) {
        // this part is attachment
        // code to save attachment...
    }
}