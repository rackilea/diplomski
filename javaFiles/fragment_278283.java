public class BrandPage extends ActionBarActivity {

private ExpandListAdapter ExpAdapter;
private ExpandableListView ExpandList;
private ArrayList<Group> ExpListItems;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_brand_page);
    Button b1 = (Button) findViewById(R.id.button);
    b1.setOnClickListener(new View.OnClickListener() {


        @Override
        public void onClick(View v) {
            Intent i = new Intent(BrandPage.this, MyActivity.class);
            startActivity(i);

        }
    });


    ExpandList = (ExpandableListView) findViewById(R.id.exp_list);
    ExpListItems = SetStandardGroups();
    ExpAdapter = new ExpandListAdapter(BrandPage.this, ExpListItems);
    ExpandList.setAdapter(ExpAdapter);

}


public ArrayList<Group> SetStandardGroups() {