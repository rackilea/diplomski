public class ShowCustomerActivity extends Activity {
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_show_customer);
    ListView listNames;
    ArrayAdapter<String> listAdapter;
    listNames = (ListView)findViewById(R.id.listView);

    String [] names = new String[] {"Derek Jeter", "David Robertson", "Mark Texiera"};

    ArrayList<String> nameArray = new ArrayList<String>();
    nameArray.addAll(Arrays.asList(names));

    listAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, nameArray);
//The layout should be your list Item layout and not the activity layout.



    listNames.setAdapter(listAdapter);


}