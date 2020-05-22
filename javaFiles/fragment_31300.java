import java.util.ArrayList;
import java.util.List;

public class Covariance {

    class A {
    }

    class B extends A {
    }

    class C extends A {
    }

    class D extends C {}

    public void testSmth() throws Exception {
        List<? super D> ld = new ArrayList<C>();
    }

}