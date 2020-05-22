public class MainActivityFragment extends Fragment {

public final static String DATA_TYPE = "DataType";

private ArrayList<String> data = new ArrayList<>();
private String dataTag = "";

public MainActivityFragment() {
}

@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    if (getArguments() != null){
        data = getArguments().getStringArrayList(MainActivity.LISTVIEW_DATA);
        dataTag = getArguments().getString(DATA_TYPE);
    }

}

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_main, container, false);

    ListView listView = (ListView) rootView.findViewById(R.id.listView1);

    ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, data);

    listView.setAdapter(adapter);

    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int   i, long l) {

            switch (dataTag) {
                case MainActivity.DATA_TYPE1:
                    //here is where you can implement your logic for type 1
                    break;
                case MainActivity.DATA_TYPE2:
                    //here is where you can implement your logic for type 2
                    break;
                case MainActivity.DATA_TYPE3:
                    //here is where you can implement your logic for type 3
                    break;
                default:
                    //do something else
                    break;
            }

        }
    });

    return rootView;
}