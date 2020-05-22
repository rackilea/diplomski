@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.myfrag, container, false);

    detector = new GestureDetectorCompat(getActivity(), new RecyclerViewOnGestureListener());

    recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);

    layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.addOnItemTouchListener(this);

    adapter = new MyAdapter(myData));
    recyclerView.setAdapter(adapter);
    return rootView;
}