public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ll = (LinearLayout) findViewById(R.id.selectedTeamFrag);

        for (int count=0; count < 10 ; count++) {
            Button button1 = new Button(MainActivity.this);
            button1.setText("B:"+count);
            LinearLayout.LayoutParams x = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);

            button1.setLayoutParams(x);
            ll.addView(button1);
        }
    }
}