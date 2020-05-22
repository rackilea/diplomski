public class ContractTestActivity extends Activity {
private List<Contract> contracts = new ArrayList<Contract>();
public final String TAG = "ContractTest";
//public Contract newContract = new Contract();

/** Called when the activity is first created. */
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.main);
    ListView list;
    list = (ListView)findViewById(R.id.mylist);
    ArrayAdapter<Contract> adapter = new ContractAdapter(this, android.R.layout.simple_list_item_1, myContracts());
    list.setAdapter(adapter);
}

private List<Contract> myContracts(){

    List<Contract> list = new ArrayList<Contract>();

    list.add(new Contract("Friend1"));

    return list;
}