public class Issues extends Activity {

public static ArrayAdapter<String> arrayAdapter;
public static ListView serieslistview;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.issues);

    Button btaddnewseries = (Button) findViewById(R.id.button1);
    serieslistview = (ListView) findViewById(R.id.listView1);

    //opens the add new series menu
    btaddnewseries.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent myIntent = new Intent(ComicIssues.this, AddSeries.class);
            Issues.this.startActivity(myIntent);
        }
    });

String[] values = new String[] { "Item 1", 
                                         "Item 2",
                                         "Item 3",
                                         "Item 4"
                                        };

    arrayAdapter = new ArrayAdapter<String>(this,
          android.R.layout.simple_list_item_1, android.R.id.text1,values);

    serieslistview.setAdapter(arrayAdapter);

}