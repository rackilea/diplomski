public class game1 extends AppCompatActivity {

    Button loseStarter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game1);

        loseStarter1 = (Button) findViewById(R.id.Starter1);
        loseStarter1.setOnClickListener(new View.OnClickListener() {
            @Override
             public void onClick(View v) {
                loseStarter1.setVisibility(View.GONE);
            }
        }); //added semicolon

    } // ends onCreate method
} // ends class