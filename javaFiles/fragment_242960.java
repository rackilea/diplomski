public class MyCaller {
    private Handler handler;  //have a setter.

    public void callIt(int a, int b) {
        handler.myHandler(a, b);
    }
}