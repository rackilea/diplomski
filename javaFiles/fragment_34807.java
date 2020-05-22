public class MyOuter {
    private MyOuter.MyInner inner;

    public MyOuter() {
        inner = new MyOuter.MyInner();
    }

    ...

    private static class MyInner {
        ....
    }
}