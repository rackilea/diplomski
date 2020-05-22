public class MainActivity extends ActionBarActivity implements ListAdapter.OnShareClickedListener{

    ListView main_list;
    List<String> url_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        main_list = (ListView) findViewById(R.id.listView);
        ListAdapter nListAdapter = new ListAdapter(this, url_list);
        nListAdapter.setOnShareClickedListener(this);
        main_list.setAdapter(nListAdapter);
    }

    @Override
    public void ShareClicked(String url) {
        Log.e("Test", url);
    }

}