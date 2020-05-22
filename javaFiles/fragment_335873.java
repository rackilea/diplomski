public class SupportTests {

@Rule
public MockitoRule rule = MockitoJUnit.rule();

@Mock
SupportContract.ISupportMessageSender sender;
@Mock
CurrentUserOperations currentUserOperations;

private String message;

@Before
public void init(){
    message = "message";
}

@Test
public void testSendMessageToSupportShouldBeDone (){
    Support support = new Support(sender, currentUserOperations);

    when(currentUserOperations.getCurrentUserSystemId()).thenReturn(Long.valueOf(1));
    when(sender.sendSupportMessage(any(SupportMessage.class))).thenReturn(true);

    boolean actualResult = support.sendMessageToSupport(message);

    assertEquals("Sending message to support are failed.", true, actualResult);
}

}