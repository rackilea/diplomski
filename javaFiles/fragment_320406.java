import java.util.*;

public class C1 implements Iterable<C1.NC1> {
    private LinkedList<NC1> list;
    public static class NC1 {
    }

    public Iterator<C1.NC1> iterator() {
        return list.iterator();
    }
}