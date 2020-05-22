public class MyObjectRow {
    private MyObject wrapped;
    private int index;

    //...
    public String getParam1() {
        return wrapped.getParam1();
    }
    public String getParam2() {
        return wrapped.getParam2();
    }
    public String getParam3() {
        return wrapped.getParam3().get(index);
    }
}