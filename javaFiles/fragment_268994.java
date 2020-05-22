private ListView listview;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.YOUR_FRAGMENT_LAYOUT, container, false);

    listview = (ListView) v.findViewById(R.id.R.id.list);
    return v;
}