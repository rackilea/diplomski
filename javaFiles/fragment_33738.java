@Autowired
private MailingServiceImpl mailingServiceImpl;

@Rule
public final GreenMailRule greenMail = new GreenMailRule(ServerSetupTest.SMTP);

@Test
public void testSendMail() throws IOException {
    mailingServiceImpl.sendMail("sender", "receiver", "subject", "content");
    MimeMessage[] emails = greenMail.getReceivedMessages();
    assertEquals(1, emails.length);
}