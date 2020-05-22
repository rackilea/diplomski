@Mock
private MailSender mailSender;
private EmailService emailService;
private String emailRecipientAddress = "recipient@abc.com";
private String emailSenderAddress = "sender@abc.com";
private String messageBody = "Hello Message Body!!!";

@Before
public void setUp(){
    MockitoAnnotations.initMocks(this);
    emailService = new EmailService(mailSender, emailRecipientAddress, emailSenderAddress);
}

@Test
public void testMessageSent() throws MailException {

    ArgumentCaptor<MailMessage> argument = ArgumentCaptor.forClass(MailMessage.class);

    emailService.notify(messageBody);

    Mockito.verify(mailSender).send(argument.capture());
    Assert.assertEquals(emailRecipientAddress, argument.getValue().getTo());
    Assert.assertEquals(emailSenderAddress, argument.getValue().getFrom());
    Assert.assertEquals(messageBody, argument.getValue().getText());

}