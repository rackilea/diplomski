@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    ArrayAdapter<String> adapter = new ArrayAdapter<String>(
            getActivity(), android.R.layout.simple_list_item_1,
            new String[]{ "one", "two", "three"});
    setListAdapter(adapter);

    View layout = inflater.inflate(R.layout.list_fragment_layout, container, false);
    MyCustomView myView = (MyCustomView) layout.findViewById(R.id.custom_view_id);

    return layout;
}