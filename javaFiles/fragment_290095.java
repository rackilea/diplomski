public class SendAccountActivationEmailEventListener 
      implements ApplicationListener<AccountActivationEvent> {

  private MailSenderService mailSender;

  .... 

  public final void onApplicationEvent(final AccountActivationEvent event) {
   Account account = event.getActivatedAccount():
    .... perform mail ...
   mailSender.sendEmail(email);
  }
 }