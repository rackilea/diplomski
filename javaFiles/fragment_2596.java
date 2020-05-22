public class GreenMailTest extends UnitTest {

  private GreenMail mail;

  @Before
  public void startGreenMail() {
    GreenMail greenMail = new GreenMail();
    greenMail.start();  
  }

  @Test
  public void myTestThatUsesGreenMail() {
    GreenMailUtil.sendTextEmailTest("to@localhost.com", "from@localhost.com", "subject", "body");
    assertEquals("body", GreenMailUtil.getBody(greenMail.getReceivedMessages()[0]));
  }

  @After
  public void stopGreenMail() {
    greenMail.stop();
  }

}