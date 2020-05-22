import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class SomeTest {

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }

    @Before
    public void setUp() {

        // Here goes the code, which makes sure, all tests
        // see the same context

        System.out.println("setUp");
    }

    @BeforeClass
    public static void setUpGlobals() {

        // Expensive hibernate set-up will go here. It is
        // called only once

        System.out.println("setUpGlobals");
    }
}