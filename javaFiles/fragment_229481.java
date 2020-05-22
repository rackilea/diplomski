public class AnotherActivity extends Activity {
    FragmentB f2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        FragmentManager mang = getFragmentManager();
        Log.d("this", "Another Activity");

        Log.d("this", "fragment2 in Another Activity");
        Intent i = getIntent();
        int index = i.getIntExtra("index", 0);
        Bundle bund = new Bundle();
        bund.putInt("val", index);
        f2 = (FragmentB) mang.findFragmentById(R.id.fragment2);
        f2.changeText(index);
        Log.d("this", "Get intent extras");

    }

}