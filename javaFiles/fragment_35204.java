public boolean sendEWSMail(String subject, String bodyContent, String to, String cc){
    ExchangeService service = new ExchangeService();
    EmailMessage msg = null; 
    ExchangeCredentials credentials = null;
    String domain = "domain name";
    if (domain == null || domain.equals("")) {
        credentials = new WebCredentials("username", 
                "password");
    } else {
        credentials = new WebCredentials("username", 
                "password", domain);
    }
    service.setCredentials(credentials);
    try {
        service.setUrl(new URI("Mail server URL"));
        msg = new EmailMessage(service);
        msg.setSubject(subject); 
        msg.setBody(MessageBody.getMessageBodyFromText(bodyContent));
        msg.getAttachments().addFileAttachment("Complete File Path");
        if(to == null || to.equals("")){
            LOGGER.warn("To distribution list is empty. Could not send the mail ");
        }else{
            String[] mailTos = to.split(";");
            for(String mailTo : mailTos){
                if(mailTo != null && !mailTo.isEmpty())
                msg.getToRecipients().add(mailTo);
            }
            if(cc != null && !cc.isEmpty()){
                String[] mailCCs = cc.split(";");
                for(String mailCc : mailCCs){
                    if(mailCc != null && !mailCc.equals(""))
                    msg.getCcRecipients().add(mailCc);
                }
            }
            msg.send();
            LOGGER.debug("Mail successfully send ");
            return true;
        }
    } catch (Exception e) {
        LOGGER.error("Exception occurred while sending EWS Mail ", e);
    }
    return false;
}