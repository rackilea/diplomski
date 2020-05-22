public class YourActivity extends Activity {

    private static class OnCreateListenerImpl implements OnCreateListener {

        @Override
        public void onObjCreate() {
            Log.d("pltk", "dfgbfdgh");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palatok);

        OnCreateListener inter = new OnCreateListenerImpl();
        Intent in = new Intent(Palatok.this, SecondActivity.class);
        in.putExtra("ob", inter);
        startActivity(in);
    }
}