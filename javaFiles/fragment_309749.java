public class TestClassToTest {

    @Mock
    File mockOfAFile;

    @Mock
    File fileMock; // the new mock

    @Test
    public void testAMethod() { // no parameters
        MockitoAnnotations.initMocks(this);
        given(fileMock.getName()).willReturn("test1"); // here is the new mock used
        assertEquals("test1",ClassBeingTested.methodBeingTested(mockOfAFile));
    }
}