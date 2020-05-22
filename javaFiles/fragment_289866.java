public class BeforeAfterTest {
    @Rule public TestRule rule = new ExternalResource() {
        protected void before() throws Throwable { System.out.println("externalResource before"); }
        protected void after() { System.out.println("externalResource after"); }
    };

    @Test public void testHere() { System.out.println("testHere"); }
}