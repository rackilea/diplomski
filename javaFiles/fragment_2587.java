public static String saveAttachments(String EMAIL_ID)
{
    try
    {
        String saveDirectory = "C:\\Email\\Attachements\\";

        //Get email record from DB
        EMAIL newEMAILObj = EMAIL.getEmailDetailsForEmailId(EMAIL_ID);

        //Get email raw data into a String variable
        String emailRawData = newEMAILObj.getCONTENT();

        Session newSession = Session.getDefaultInstance(new Properties());
        InputStream inputStreamObj = new ByteArrayInputStream(emailRawData.getBytes());
        MimeMessage mimeMessageObj = new MimeMessage(newSession, inputStreamObj);
        String contentType = mimeMessageObj.getContentType();

        if (contentType.contains("multipart")) //Content may contain attachments
        {
            Multipart multiPart = (Multipart) mimeMessageObj.getContent();
            int numberOfParts = multiPart.getCount();
            for (int partCount = 0; partCount < numberOfParts; partCount++)
            {
                MimeBodyPart part = (MimeBodyPart) multiPart.getBodyPart(partCount);
                if (Part.ATTACHMENT.equalsIgnoreCase(part.getDisposition())) //This part is an attachment
                {
                    File file = new File(saveDirectory+part.getFileName());
                    part.saveFile(file);
                }
            }
        }
    }
    catch (MessagingException ex) 
    {
        return "FAILED: "+ex.getLocalizedMessage();
    }
    catch (IOException ex)
    {
        return "FAILED: "+ex.getLocalizedMessage();
    } 
    return "SUCCESS";
}