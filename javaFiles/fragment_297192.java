public class ATest {
    private final MocksCollector mocksCollector = new MocksCollector();

    @Test
    public void test() throws Exception {
        A a1 = mock(A.class);
        A a2 = mock(A.class);
        A a3 = mock(A.class);
        assertEquals("wrong amount of mocks", 3, mocksCollector.getMocks().length);
        verifyNoMoreInteractions(mocksCollector.getMocks());
        a3.doSomething();
        verifyNoMoreInteractions(mocksCollector.getMocks()); // fail
    }
}