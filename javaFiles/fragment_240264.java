public class MyList extends LinkedList {
    public void add(Object o) {
        Thread.sleep(10000);
        super.add(o);
    }
}