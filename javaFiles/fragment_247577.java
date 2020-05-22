public class MainActivity extends AppCompatActivity {
    EditText from;
    EditText to;
    TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        from = (findViewById(R.id.editTextFrom));
        to = (findViewById(R.id.editTextTo));
        output = (findViewById(R.id.textViewOutput));
    }

    public void generate(View view) {
        // Get values of from and to edit text
        String wfrom = from.getText().toString();
        String wto = to.getText().toString();

        // Validate from value
        if (TextUtils.isEmpty(wfrom)) {
            Toast.makeText(MainActivity.this, "the -From- value is empty!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        // Validate to value
        if (TextUtils.isEmpty(wto)) {
            Toast.makeText(MainActivity.this, "the -To- value is empty!",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        int numberfrom = Integer.parseInt(wfrom);
        int numberto = Integer.parseInt(wto);
        // Check whether from larger or equal than to
        if (numberfrom >= numberto) {
            Toast.makeText(MainActivity.this, "the -To- value must be greater than the -From- value",
                    Toast.LENGTH_SHORT).show();
            return;
        }

        // Generate a random number in range [from - to]
        Random randomNumberGenerator = new Random();
        int number = randomNumberGenerator.nextInt(numberto - numberfrom) + numberfrom;

        // Display the random number on output text view
        output.setText(number + "");

        // Log for debug
        Log.d("test", "it's from:" + numberfrom + " to this:" + numberto + "generatednumber" + number);
    }
}