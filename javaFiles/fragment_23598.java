public class SecondActivity extends AppCompatActivity {
    private void someFunction () {
        sendMessage ();
    }
    ...
    private void sendMessage() {
        Log.d("sender", "Broadcasting message");
        Intent intent = new Intent("webview-filter");

        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);
    }
    ...
}