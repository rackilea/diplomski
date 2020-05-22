public abstract class AbstractTest {

    protected abstract void test() throws Exception;
}

public class ConcreteTest extends AbstractTest {

    @Override
    public void test() throws Exception {

    }
}