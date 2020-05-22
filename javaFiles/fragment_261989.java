public void testTemplateMail() {
    try {
        MandrillMessage message = new MandrillMessage();

        //Set recipient
        ArrayList<Recipient> recipients = new ArrayList<Recipient>();
        Recipient recipient = new Recipient();
        recipient.setEmail("someone@something.com");
        recipient.setName("Someone");
        recipients.add(recipient);
        message.setTo(recipients);
        message.setPreserveRecipients(true);

        //Set global merge vars
        List<MergeVar> globalMergeVars = new ArrayList<>();
        MergeVar mergeVar = new MergeVar();
        mergeVar.setName("name_placeholder");
        mergeVar.setContent("Someone");
        globalMergeVars.add(mergeVar);
        message.setGlobalMergeVars(globalMergeVars);

        //Set merge language (*important)
        message.setMergeLanguage("handlebars");

        //You must provide at least an empty template content
        Map<String, String> template_content = new HashMap<>();

        //Send mail
        MandrillMessageStatus[] messageStatusReports = mandrillApi
                .messages().sendTemplate("my_test_template", template_content, message, false);
        if (messageStatusReports != null && messageStatusReports.length > 0) {
            logger.info("Mail sent info: " + messageStatusReports[0].getStatus());
        }
    } catch (MandrillApiError e) {
        logger.error(e.getMessage());
    } catch (IOException e) {
        logger.error(e.getMessage());
    }
}