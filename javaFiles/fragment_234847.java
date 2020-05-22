public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    View view = inflater.inflate(
            R.layout.announcement_recycler_view, container, false);
    announcementRecyclerView = view.findViewById(R.id.my_announcement_recycler_view);

    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
    announcementRecyclerView.setLayoutManager(layoutManager);

    //initializing the productlist
    announcementList = new ArrayList<>();

    // Session class instance
    session = new SharedPrefManager(getActivity());

    loadAnnouncement();

    return view;
}