public class MainActivity extends Activity implements OnItemClickListener {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listView1);

        ArrayAdapter<String> array = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_dropdown_item_1line, getResources()
                        .getStringArray(R.array.titles));
        lv.setAdapter(array);

        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapter, View view, int position,
            long id) {

        // TODO Auto-generated method stub

        String value = lv.getAdapter().getItem(position).toString();
        Intent i = new Intent(getApplicationContext(), SecondActivity.class);
        i.putExtra("index", value);
        startActivity(i);

    }

}