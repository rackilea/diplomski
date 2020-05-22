public class ChooseHelp extends ActionBarActivity {

private ArrayList<String> results;
ListView listView;
ArrayAdapter listAdapter;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_help);

    results = new ArrayList<>();
    openAndQueryDatabase();

    listView = (ListView)findViewById(R.id.listview);
    listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, results);
    listView.setAdapter(listAdapter);
    listView.setOnItemClickListener(onListClick);
}