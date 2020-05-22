import org.testng.Assert;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class TempTest {

    private Integer number;

    @BeforeMethod
    public void init(Method m) {
        number = 5;
        switch(m.getName()) {
            case "test2":
                fun(10);
                fun2(5);
                break;
            case "test1":
                fun(10);
                break;
        }
    }

    public void fun(int value) {
        number += value;
    }

    public void fun2(int value) {
        number -= value;
    }

    @Test
    public void test1() {
        Assert.assertEquals(new Integer(15), number);
    }

    @Test
    public void test2() {
        Assert.assertEquals(new Integer(10), number);
    }

    @Test
    public void test3() {
        Assert.assertEquals(new Integer(5), number);
    }

}