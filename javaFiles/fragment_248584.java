public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText et;
    String rns; /* Declarations here */
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et = (EditText) findViewById(R.id.regNum); /* regNum is android id */

        b = (Button) findViewById(R.id.regBut); /* regBut is android id */
        b.setOnClickListener(MainActivity.this);
    }

    public void onClick(View v){
        if (v == b){
            /* Get the string from the edittext on button press */
            rns = et.getText().toString();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW,Uri.parse
("https://www.vegvesen.no/kjoretoy/Kjop+og+salg/Kjøretøyopplysninger?registreringsnummer=" + rns));
           startActivity(browserIntent);
        }
    }