private ListAdapter mAdapter;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    ...
    mAdapter = new ListAdapter(getActivity();
    listview.setAdapter(mAdapter);
    ...
}