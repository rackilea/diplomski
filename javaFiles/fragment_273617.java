public class ATest {
    @Test
    public void test() {
        final A a = spy(new A());
        doReturn(10).when(a).methodTwo(anyInt());
        doCallRealMethod().when(a).methodOne();
        a.methodOne();
        verify(a, times(1)).methodTwo(anyInt());
    }
}