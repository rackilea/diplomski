com.google.api.services.gmailGmail service = (... defined above ...)
javax.mail.internet.MimeMessage message = (... defined above with attachments embedded ...)

/**
 * Send email using Gmail API - dynamically uses simple or multipart send depending on attachments size
 * 
 * @param mimeMessage MimeMessage (includes any attachments for the email)
 * @param attachments the Set of files that were included in the MimeMessage (if any).  Only used to calculate total size to see if we should use "simple" send or need to use multipart upload.
 */
void send(MimeMessage mimeMessage, @Nullable Set<File> attachments) throws Exception {

    Message message = new Message();
    ByteArrayOutputStream buffer = new ByteArrayOutputStream();
    mimeMessage.writeTo(buffer);

    // See if we need to use multipart upload
    if (attachments!=null && computeTotalSizeOfAttachments(attachments) > BYTES_5MB) {

        ByteArrayContent content = new ByteArrayContent("message/rfc822", buffer.toByteArray());
        message = service.users().messages().send("me", null, content).execute();

    // Otherwise, use "simple" send
    } else {

        String encodedEmail = Base64.encodeBase64URLSafeString(buffer.toByteArray());
        message.setRaw(encodedEmail);
        message = service.users().messages().send("me", message).execute();
    }

    System.out.println("Gmail Message: " + message.toPrettyString());
}