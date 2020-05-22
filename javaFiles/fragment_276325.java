public class A<V> {

    public int a;
    public int b;
    private Callable<V> callable;

    public A(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public V theFunction() {
        try {
            return callable.call();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void setTheFunction(Callable<V> callable) {
        this.callable = callable;
    }
}