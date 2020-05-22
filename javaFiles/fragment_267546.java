import com.icegreen.greenmail.util.GreenMail;
import com.icegreen.greenmail.util.GreenMailUtil;
import com.icegreen.greenmail.util.ServerSetupTest; ...

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("ApplicationContext-Greenmail.xml")
public class EmailServiceIntegrationTest {

    /** Class under test */
    @Resource
    private EmailService emailService;

    private GreenMail greenMail;

    @Before
    public void startMailServer() {
        greenMail = new GreenMail(ServerSetupTest.SMTP);
        greenMail.start();
    }

    @After
    public void stopMailServer() {
        greenMail.stop();
    }

    @Test
    public void testPledgeReminder()
                throws InterruptedException, MessagingException {

        String mailText = "Hallo World";
        String mailSubject = "Hallo";
        String mailTo = "test@excaple.com";

        /** when: sending a mail */
        emailService.send(mailSubject, mailTo, mailText);

        assertTrue(greenMail.waitForIncomingEmail(5000, 1));
        Message[] messages = greenMail.getReceivedMessages();
        assertEquals(1, messages.length);
        assertEquals(mailText, messages[0].getSubject());       
        String body = GreenMailUtil.getBody(messages[0]).replaceAll("=\r?\n", "");
        assertEquals(mailText, body);       
    }

}