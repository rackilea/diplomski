import java.util.ArrayList;
import java.util.Collection;

class Base {

}

class A extends Base {

}

public class MyType {
    public void printBase(Collection<Base> bases) {
        for (Base base : bases) {
            System.out.println(base.toString());
        }
    }

    public <A extends Base> void myMethod(Collection<A> things) {
        Collection<Base> lst = new ArrayList<Base>();
        lst.addAll(things);
        printBase(lst);
    }
}