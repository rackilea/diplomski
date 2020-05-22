import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class LinkedListsApp {

    public static void main(String[] args) throws Exception {
        LinkedList<AtomicInteger> l1 = new LinkedList<>();
        l1.add(new AtomicInteger(100));
        l1.add(new AtomicInteger(200));

        LinkedList<AtomicInteger> l2 = (LinkedList) l1.clone();
        l2.add(new AtomicInteger(300));

        System.out.println(l1);
        System.out.println(l2);

        // change element on first list
        l1.get(0).incrementAndGet();

        System.out.println();
        System.out.println("After change internal state of first element");
        System.out.println(l1);
        System.out.println(l2);
    }
}