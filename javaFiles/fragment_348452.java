public class PlanetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);

        ((TextView) findViewById(R.id.title)).setText(getIntent().getStringExtra("planet"));

    }
}