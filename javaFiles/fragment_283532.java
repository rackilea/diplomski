MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
               message.setTo("blabla@test.com");
               message.setSubject("Email test");

               String text = VelocityEngineUtils.mergeTemplateIntoString(
                   velocityEngine, template, keywords);
               message.setText(text, true);

             }
          };

          //Send email using the autowired mailSender
          this.mailSender.send(preparator);