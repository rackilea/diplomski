@Config(browser = Browser.PHANTOMJS, url = "http://google.com")
public class PhantomJSTest extends Locomotive {
    @Test
    public void testPhantomJSWorks() {
        setText("[name='q']", "Test");
    }
}