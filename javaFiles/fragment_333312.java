private RecyclerView mRecyclerView;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_list, container, false);
    // Add this.. Here, view won't be null
    recyclerView = view.findViewById(R.id.rcl);
    return view;
}

@Override
public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    // recyclerView = view.findViewById(R.id.rcl); --> Remove this from here.
    recyclerView.setHasFixedSize(true);
    layoutManager = new LinearLayoutManager(this.getActivity());
    recyclerView.setLayoutManager(layoutManager);
    adapter = new PersonAdapter(this.getActivity(), ApplicationClass.people);
    recyclerView.setAdapter(adapter);
}