public class MyActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstance) {
        // ....
        Handler myHandler = new Handler() {
            @Override
            public void handleMessage (Message msg) {
                doCoolStuffWhenMessageReceived();
            }
        }
        MySecondClass secondClass = new MySecondClass(myHandler);
        // ....
    }
}