public class MainActivity extends AppCompatActivity {

    private Button mfactbutton;
    private TextView mfacttext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mfactbutton = (Button) findViewById(R.id.button);
        mfacttext = (TextView) findViewById(R.id.textView2);

        // now we need to make out button to click
        View.OnClickListener Listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String[] facts = {
                        "Ants stretch when they wake up in the morning.",
                        "Ostriches can run faster than horses.",
                        "Olympic gold medals are actually made mostly of silver.",
                        "You are born with 300 bones; by the time you are an adult you will have 206.",
                        "It takes about 8 minutes for light from the Sun to reach Earth.",
                        "Some bamboo plants can grow almost a meter in just one day.",
                        "The state of Florida is bigger than England.",
                        "Some penguins can leap 2-3 meters out of the water.",
                        "On average, it takes 66 days to form a new habit.",
                        "Mammoths still walked the earth when the Great Pyramid was being built." };

                String fact = "";

                Random randomGenerator = new Random();
                int randomNumber = randomGenerator.nextInt(facts.length);

                fact = facts[randomNumber] + "";

                mfacttext.setText(fact);
                Toast.makeText(getApplicationContext(), "Fact: " + fact, Toast.LENGTH_SHORT).show();
            }
        };

        mfactbutton.setOnClickListener(Listener);
    }
}