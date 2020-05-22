public class YourTest {

  @Mock SomeClass someMock;
  @Captor ArgumentCaptor<List<EditJobSettingsSet>> argument;

  @Before public void initializeMocks() {
    // This gets called automatically if you @RunWith(MockitoJUnitRunner.class).
    MockitoAnnotations.initMocks(this);
  }

  @Test public void yourTest() {
    // [insert setup here]
    verify(mEditJobListener).settingsAdded(argument.capture());
    // [insert assertions here]
  }
}