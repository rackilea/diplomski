// This annotation enables the @Mock, etc. annotations
@RunWith(MockitoJUnitRunner.class)
public class DemoPublisherTest {

    // This creates an instance of this class and then injects all the mocks if possible
    @InjectMocks
    private DemoPublisher demoPublisher;

    // This creates a mocked instance of that class
    @Mock
    private JmsTemplate jmsTemplate;

    @Test
    public void demoPublishMessage_must_call_jmsTemplate_method() {

         // Call the class to test
         this.demoPublisher.demoPublishMessage("test");

         // And now verify that the method was called exactly once with the given parameters
         Mockito.verify( this.jmsTemplate, Mockito.times(1)).convertAndSend(("NewQueue", "test");
    }

}