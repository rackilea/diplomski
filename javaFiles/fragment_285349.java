private void setMessageProcessor() {
    mHandler = new Handler() {
        ...
    }
}

public class SerialPortListener {
...
private static int testNumber = 1;
public static void start() {
    ...
    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {
                Message msg = mHandler.obtainMessage();
                msg.obj = testNumber++;
                msg.sendToTarget();
                Log.i("TEST", "TEST);
                ...
        }
    }
}