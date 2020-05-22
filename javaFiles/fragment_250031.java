public class NullTest {
    public static void main (String[] args) {
        Object o = new Object();
        o = null;
        o.notifyAll();
    }
}