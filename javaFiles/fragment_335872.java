ExecutorService executor = Executors.newFixedThreadPool(50);

public void sendEmail(final String subject, final String recipient, final ModelMap mm, final String emailTemplate, final String from) {
 MimeMessagePreparator preparator = new MimeMessagePreparator() {
       // rest of your mail building logic
      };

  executor.submit(preparator);

}