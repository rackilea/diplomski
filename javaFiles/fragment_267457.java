private void sendMail(final Object backingObject) {     
    MimeMessagePreparator preparator = new MimeMessagePreparator() {
        public void prepare(MimeMessage mimeMessage) throws Exception {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, true);

            // Set subject, from, to, ....

            // Set model, which then will be used in velocity's mail template
            Map<String, Object> model = new HashMap<String, Object>();
            model.put("backingObject", backingObject);

            // Add this line in order to initialize DateTool
            model.put("date", new DateTool());

            String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "mail_template.vm", model);
            message.setText(text, true);

        }
    };
    this.javaMailSender.send(preparator);
}