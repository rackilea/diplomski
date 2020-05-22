public class DemoListView extends AppCompatActivity implements ListAdapter.PlaceClickInterface {

    ListView listView ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_demo_list);

        List<String> places = new ArrayList<>(Arrays.asList("New york","washington","london"));
        listView = (ListView)findViewById(R.id.list_view_demo);
        ListAdapter adapter = new ListAdapter(places , this) ;
        listView.setAdapter(adapter);
    }


    @Override
    public void onPlaceClick(int position) {
        Log.v("DemoListView" , "position : "+position) ;
        //show dialog here with Alert dialog builder or ListFragment class with custom UI
    }
}