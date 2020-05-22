public class OtherActivity extends Activity {

    public static String EXTRA_COLOR = "EXTRA_COLOR";

    public void onCreate(...) {

        View one = (Button) findViewById(R.id.one);

        //NOTE: if you add singleTop to this activity in the manifest
        //      you might need to do this on onNewIntent

        Intent intent = getIntent();
        if (intent.hasExtra(EXTRA_COLOR)) {
            int color = intent.getIntExtra(EXTRA_COLOR, Color.WHITE);
            one.setBackgroundColor(color);
        }

    }

}