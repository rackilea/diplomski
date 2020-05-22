protected void processMimeMultipart(javax.mail.internet.MimeMultipart mimeMultipart) throws Exception {
        for(int i = 0; i< mimeMultipart.getCount();i++){
            BodyPart bodyPart = mimeMultipart.getBodyPart(i);
            int attachmentSize = getAttachmentSize(bodyPart);
        }
    }
    protected int getAttachmentSize(final javax.mail.BodyPart bodyPart) throws Exception {
        if(Part.ATTACHMENT.equalsIgnoreCase(bodyPart.getDisposition())) {
            return bodyPart.getSize();
        }
        return -1;
    }