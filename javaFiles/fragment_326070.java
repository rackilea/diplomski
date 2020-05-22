public class CustomActivity extends Activity {

    private static final String EXTRA_SOME_THING = "CustomActivity.EXTRA_SOMETHING";

    public Intent newIntent(Context context, int arg1) {
        Intent intent = new Intent(context, getClass());
        intent.putExtra(EXTRA_SOME_THING arg1);
        return intent;
    }

    //... other methods
}