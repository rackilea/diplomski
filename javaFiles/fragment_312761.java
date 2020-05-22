@Override 
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_discover_list, container, false);

    mDiscoverList = (RecyclerView) view.findViewById(R.id.discover_list);
    LinearLayoutManager gridLayoutManager = newLinearLayoutManager(getContext());
    mDiscoverList.setLayoutManager(gridLayoutManager);
    mDiscoverList.setHasFixedSize(true); 

    return view;
}