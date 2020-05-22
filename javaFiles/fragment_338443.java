import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;

class MyObject{
    public String cos;

    public MyObject(String cos) {
        this.cos = cos;
    }

    public boolean xyz() {
        return true;
    }
}

class A {
    protected static MyObject a;
    public void someMethod() {
        a = new MyObject("cccc");
    }
}

public class B  extends A {
    @Before
    public void setUpBeforeTest() {
        someMethod();
    }
    @Test
    public void mockTest() {
        MyObject mock_object = Mockito.spy(a);
        Mockito.doReturn(false).when(mock_object).xyz();
        assertThat(mock_object.xyz()).isFalse();
    }
    @Test
    public void mockTest2() {
        MyObject mock_object = Mockito.spy(a);
        Mockito.doReturn(true).when(mock_object).xyz();
        assertThat(mock_object.xyz()).isTrue();
    }

}