public class EmailSendingServletTest {
  ...
  private EmailSendingServlet emailSendingServlet;
  private EmailSendingServlet emailSendingServletSpy;
  ...

  public EmailSendingServletTest(){
    emailSendingServlet =  new EmailSendingServlet();
    emailSendingServletSpy = Mockito.spy(emailSendingServlet);
  }
}