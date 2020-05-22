public class MainActivity extends Activity {

    private ListView listView1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        MyData my_data[] = new MyData[]
        {
            new Weather("Peter", "12345"),
           };

        MyAdapter adapter = new MyAdapter(this, 
                R.layout.listview_item_row, my_data);


        listView1 = (ListView)findViewById(R.id.listView1);

        View header = (View)getLayoutInflater().inflate(R.layout.listview_header_row, null);
        listView1.addHeaderView(header);

        listView1.setAdapter(adapter);
    }