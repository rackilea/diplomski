public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView leftDice = (ImageView)findViewById(R.id.image_leftDice);
        final ImageView rightDice = (ImageView) findViewById(R.id.image_rightDice);

        final int[] diceArray = {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        Button rollButton;
        rollButton = (Button) findViewById(R.id.rollButton);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Random randomNumberGenerator = new Random();

                int numberForLeftDice = randomNumberGenerator.nextInt(6);
                int numberForRightDice = randomNumberGenerator.nextInt(6);

                leftDice.setImageResource(diceArray[numberForLeftDice]);
                rightDice.setImageResource(diceArray[numberForRightDice]);

                if (numberForLeftDice == numberForRightDice) {
                    Toast.makeText(MainActivity.this, "Number Matched", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}