public class MyActivity extends Activity {

protected void onStart() {
    super.onStart();


    String someKey = null;
    String someOtherKey = null;

    Bundle extras = getIntent().getExtras();
    if (extras != null) {
        jsEnv = extras.getString("SOME_KEY");
        serverEnv = extras.getString("SOME_OTHER_KEY");
    }
}