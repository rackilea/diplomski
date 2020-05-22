public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                     @Nullable Bundle savedInstanceState) {
View v = inflater.inflate(R.layout.fragment_genres, container, false);
recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
recyclerView.setHasFixedSize(true);
layoutManager = new LinearLayoutManager(getActivity());
recyclerView.setLayoutManager(layoutManager);
return v;