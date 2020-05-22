public class EditHolidaysActivity extends ActionBarActivity {
public static final String PREFS_NAME = MainActivity.PREFS_NAME;
private final static String TEXT_DATA_KEY = "textData";
private CommentsDataSource datasource;
private ListView lstView;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edit_holidays);

    lstView = (ListView)findViewById(R.id.list);

    datasource = new CommentsDataSource(this);
    datasource.open();

    List<Comment> values = datasource.getAllComments();

    // use the SimpleCursorAdapter to show the
    // elements in a ListView
    ArrayAdapter<Comment> adapter = new ArrayAdapter<Comment>(this,
            android.R.layout.simple_list_item_1, values);
    lstView.setAdapter(adapter);
}