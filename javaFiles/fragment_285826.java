Toolbar search;
MaterialSearchView search_view;
@Nullable
@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View v =  inflater.inflate(R.layout.search_view,container,false);
    setHasOptionsMenu(true);
    search = (Toolbar)v.findViewById(R.id.toolbar2);
    ((AppCompatActivity) getActivity()).setSupportActionBar(search);
    ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("Contacts");

    return v;
}