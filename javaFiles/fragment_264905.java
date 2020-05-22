@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view =  inflater.inflate(R.layout.fragment_notification,container,false);

    addData();

    recyclerView = (RecyclerView)  view.findViewById(R.id.recycler_view);

    adapter = new NotificationAdapter(notificationModelArrayList);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(NotificationFragment.this);
    recyclerView.setLayoutManager(layoutManager);
    recyclerView.setAdapter(adapter);

    return view;
}