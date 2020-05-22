@RunWith(MockitoJUnitRunner.class)
public class A2Test {
    private final MocksCollector mocksCollector = new MocksCollector();

    @Mock
    private A a1;
    @Mock
    private A a2;
    @Mock
    private A a3;

    @Test
    public void test() throws Exception {
        assertEquals("wrong amount of mocks", 3, mocksCollector.getMocks().length);
        verifyNoMoreInteractions(mocksCollector.getMocks());
        a2.doSomething();
        verifyNoMoreInteractions(mocksCollector.getMocks()); // fail
    }
}