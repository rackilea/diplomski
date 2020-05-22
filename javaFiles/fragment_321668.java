public class FragmentA extends Fragment
{
    private String[] friendList;
    private FragmentAListener listener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (!(activity instanceof FragmentAListener)) {
            throw new RuntimeException("Activity must implements FragmentAListener");
        }
        listener = (FragmentAListener) activity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenta, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        friendList = getResources().getStringArray(R.array.FriendsList);
        textView.setText(friendList[0]);
        AdapterClass adapterClass = new AdapterClass(inflater.getContext(), friendList, listener);
        listView.setAdapter(adapterClass);
        listView.setOnItemClickListener(itemClickListener);
        return view;
    }

    private AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener()
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //TODO your code
        }
    };


    public interface FragmentAListener
    {
        void onListItemButtonClicked(String itemName);
    }
}