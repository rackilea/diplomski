public class testApiControllerTest {
private MockMvc mockMvc;
private TesApiController testApiController;
private TestFeedService testService;

@Before
public void setup() {
  this.testService = mock(TestFeedService.class);
}

@Test
public void testProcessMessage() {
  this.testApiController = new TestApiController(this.testService);
  // More code
}}