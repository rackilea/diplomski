public class MySecondClass {
    private Handler handler;
    public MySecondClass(Handler handler){
        this.handler = handler;
    }

    private void someMethodToCallActivity() {
        handler.sendEmptyMessage(0);
    }

}