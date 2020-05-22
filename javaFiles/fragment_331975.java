public class MainActivity extends AppCompatActivity {
    ImageView obama;
    ImageView will;

    public void fade(View view) {
        obama.animate().alpha(0f).setDuration(2000);
        will.animate().alpha(1f).setDuration(2000);

    }

    public void fadeBack(View view) {
        will.animate().alpha(1f).setDuration(2000);
        obama.animate().alpha(0f).setDuration(2000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        obama = (ImageView) findViewById(R.id.obama);
        will = (ImageView) findViewById(R.id.will);

        ......

    }

    ......
}