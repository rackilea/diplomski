public class LogBug {
    @Test
    public void see() {
        System.out.println("foo");
        throw new AssertionError("bar");
    }
    @Test
    public void see2() {
        System.out.println("foo2");
        throw new AssertionError("bar2");
    }
}