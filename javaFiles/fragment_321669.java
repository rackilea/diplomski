public class FragmentB extends Fragment
{
    public static final String ITEM_NAME_KEY = "item_name";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentb, container, false);
        //TODO find your views here
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText("Its FragmentB. Selected item: " + getArguments().getString(ITEM_NAME_KEY));
        return view;
    }
}