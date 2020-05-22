public class PersonProfile extends AppCompatActivity {
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.person_profile);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);

    Long intent = getIntent().getExtras().getLong("id");
    DatabaseHandler db = new DatabaseHandler(this);
    db.getReadableDatabase();

    String budgetSet = db.getPerson(intent);


    TextView textViewBudget = (TextView) findViewById(R.id.person_budget);

    textViewBudget.setText(budgetSet);

    db.close();

}