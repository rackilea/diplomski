public class MainActivity extends AppCompatActivity {

    ImageButton imageButtonPear;
    TextView showValue;
    int pears = 0;

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getApplicationContext().getSharedPreferences("PearCount", MODE_PRIVATE);

        showValue = (TextView) findViewById(R.id.countText);

        pears = pref.getInt("pearCount", 0); // This will get the value of your pearCount, It will return Zero if its empty or null.
        showValue.setText(pears + " pears");
    }


    public void PearIncrease(View v) {
        editor = pref.edit();
        pears++;
        showValue.setText(pears + " pears");
        editor.putInt("pearCount", pears);
        editor.apply();
    }
}