import junit.framework.TestCase;

public class ReplaceAllTest extends TestCase {

    private String s = "asdf$zxcv";

    public void testReplaceAll() {
        String newString = s.replaceAll("\\$", "X");
        System.out.println(newString);
        assertEquals("asdfXzxcv", newString);
    }

    public void testReplace() {
        String newString =s.replace("$", "");
        System.out.println(newString);
        assertEquals("asdfzxcv", newString);
    }
}