import static org.junit.Assert.assertEquals;
import org.junit.Test;
import test.Foobar.Bar;
import test.Foobar.Foo;

public class TestFooBar {

    @Test
    public void testFooBar() {
        Foo foo = Foo.newBuilder().setI(123).setExtension(Bar.j, 456).build();
        assertEquals(Integer.valueOf(456), foo.getExtension(Bar.j));
    }
}