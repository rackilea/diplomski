public class LocationActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_location);
        // find your listview
        ListView listView = (ListView) findViewById(R.id.location_listview_Id);
        // declare your ArrayAdapter and attach your ArrayList or in this case Method
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(this,
            android.R.layout.simple_list_item_1, model.getPlacesSmoked());      
        // attach the ArrayAdapter to your ListView
        listView.setAdapter(listAdapter);
        // Notify your ArrayAdapter of any changes when these ArrayLists grow
        listAdapter.notifyDataSetChanged();
}