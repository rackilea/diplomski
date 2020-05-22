public static void sendMailAndThrowException(SMTPParams sparams,String  subject, DataSource msgTextSource,DataSource[] fids,boolean debug) throws MessagingException {
    Session session=getMailSession(sparams);
PrintStream f = null;
if (debug) {            
        f= getPrintStream();        
} 
// null is System.out by javamail api
session.setDebug(debug);
session.setDebugOut(f);     

try
{
    // create a message
    MimeMessage msg = new MimeMessage(session);
    msg.setFrom(new InternetAddress(sparams.getFrom()));

    // Recipients are comma delimitted
    String to_list[] = sparams.getRecipients().split(",");
    InternetAddress[] address = new InternetAddress[to_list.length];
    for( int i=0; i< to_list.length; i++)
    {
        // MJB: remove extraneous spaces, sanity check
        String temp = to_list[i].trim();
        if (temp.length()>0) {
            address[i] = new InternetAddress(to_list[i].trim());
        }
    }
    // Addresses are always TO, never CC  or BCC in this library
    msg.setRecipients(Message.RecipientType.TO, address);
        if ((msg.getAllRecipients() == null) || (msg.getAllRecipients().length==0)) {
            throw new MessagingException("No valid recipients");
        }

    // Set the subject
    msg.setSubject(subject,"UTF-8");

    // create the Multipart and add its parts to it
    Multipart mp = new MimeMultipart();


    if (msgTextSource != null) {
        // create and fill the first message part
        MimeBodyPart mbp1 = new MimeBodyPart();
        mbp1.setDataHandler(new DataHandler(msgTextSource));
        mp.addBodyPart(mbp1);
    }

    if( fids != null)
    {
        for (int i=0;i<fids.length;i++) {
            //  create the second message part
            if (fids[i]==null) continue;
            MimeBodyPart mbp2 = new MimeBodyPart();
            //  attach the file to the message
            mbp2.setDataHandler(new DataHandler(fids[i]));
            mbp2.setFileName(fids[i].getName());
            mp.addBodyPart(mbp2);
        }
    }

    // add the Multipart to the message
    msg.setContent(mp);

    // set the Date: header
    msg.setSentDate(new java.util.Date());

    // Connect to SMTP server
    smtpSend(session, msg, sparams);

}

catch (MessagingException mex)
{
    throw mex;
} finally {
    closeDebug(f);
}


}