import org.junit.Test;


public class TestExpect {

@Test(expected=MyException.class)
public void test() throws MyException {
    new Foo().foo();
}

}