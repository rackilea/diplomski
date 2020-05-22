import java.util.ArrayList;
import java.util.List;

public class Wildcard {

    public static void main(String[] args) {
    WildcardFixed wf = new WildcardFixed();
    List<Integer> li = new ArrayList<>();
    li.add(0);
    wf.foo(li);
    System.out.println("Success WildcardFixed");

    WildcardWithT wt = new WildcardWithT();
    wt.foo(li);
    System.out.println("Success WildcardWithT");
    }
}

class WildcardError{
    void foo(List<?> i){
        i.set(0, i.get(0));
    }
}

class WildcardFixed{
    void foo(List<?> i){
        fooHelper(i);
    }
    private <T> void fooHelper(List<T> l){
        l.set(0, l.get(0));
    }
}

class WildcardWithT {
    <T> void foo(List<T> i) {
    i.set(0, i.get(0));
    }
}