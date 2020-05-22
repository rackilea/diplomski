public class DonorList extends AppCompatActivity
{
    private ListView listView;
    private ArrayList<Donor> list;
    private DonorListAdapter adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.contacts_list);
        list = new ArrayList<>();
        adapter = new DonorListAdapter(this, R.layout.contact_item, list);
        listView.setAdapter(adapter);

        Cursor cursor = SQLiteHelper.getInstance(this).getDonors();
        list.clear();
        while (cursor.moveToNext()) {
            String name = cursor.getString(1);
            String number = cursor.getString(2);
            String blood = cursor.getString(3);

            list.add(new Donor(name, number, blood));
        }

        adapter.notifyDataSetChanged();
    }
}