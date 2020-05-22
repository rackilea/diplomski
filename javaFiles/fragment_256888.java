public class MainActivity extends FragmentActivity implements View.OnClickListener{

public static final String LISTVIEW_DATA = "myData";
public static final String DATA_TYPE1 = "DataType1";
public static final String DATA_TYPE2 = "DataType2";
public static final String DATA_TYPE3 = "DataType3";

Bundle bundle = null;

ArrayList<String> items1 = new ArrayList<String>();
ArrayList<String> items2 = new ArrayList<String>();
ArrayList<String> items3 = new ArrayList<String>();

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    //set some data to the items
    items1 = generateStringData("Unit 1");
    items2 = generateStringData("Unit 2");
    items3 = generateStringData("Unit 3");

    Button btn1 = (Button) findViewById(R.id.button1);
    Button btn2 = (Button) findViewById(R.id.button2);
    Button btn3 = (Button) findViewById(R.id.button3);

    btn1.setOnClickListener(this);
    btn2.setOnClickListener(this);
    btn3.setOnClickListener(this);
}

private ArrayList<String> generateStringData(String prefix){
    ArrayList<String> temp = new ArrayList<String>();

    for (int i = 0; i<10; i++){
        temp.add(prefix + i);
    }

    return temp;
}

@Override
public void onClick(View view) {
    switch (view.getId()){
        case R.id.button1:
            bundle = new Bundle();
            bundle.putString(MainActivityFragment.DATA_TYPE, DATA_TYPE1);
            bundle.putStringArrayList(LISTVIEW_DATA, items1);
            break;
        case R.id.button2:
            bundle = new Bundle();
            bundle.putString(MainActivityFragment.DATA_TYPE, DATA_TYPE2);
            bundle.putStringArrayList(LISTVIEW_DATA, items2);
            break;
        case R.id.button3:
            bundle = new Bundle();
            bundle.putString(MainActivityFragment.DATA_TYPE, DATA_TYPE3);
            bundle.putStringArrayList(LISTVIEW_DATA, items3);
            break;
        default:
            break;
    }

    setListFragment(bundle);
}

private void setListFragment(Bundle arguments){
    Fragment fragment = new MainActivityFragment();

    if (arguments != null){
        fragment.setArguments(arguments);
    }

    FragmentManager fragmentManager = getSupportFragmentManager();
    android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    fragmentTransaction.replace(R.id.container, fragment);
    fragmentTransaction.addToBackStack("");
    fragmentTransaction.commit();
}