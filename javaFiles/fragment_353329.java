public class KeyEvents extends Fragment {


    public static KeyInfo newInstance() {
        KeyInfo fragment = new KeyInfo();
        return fragment;
    }

    EventsRecyclerViewAdapter adapter;

    ArrayList<Event> eventsList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventsOperationHandler ev = new EventsOperationHandler();

        eventsList = new ArrayList<>();

        for (int i=0; i<ev.getEvents().size(); i++) {
            Event event = new Event();

            event.keyID = ev.getEvents().get(i).get(0);
            event.lockID = ev.getEvents().get(i).get(1);
            event.eventTime = ev.getEvents().get(i).get(2);
            event.eventType = ev.getEvents().get(i).get(3);

            eventsList.add(event);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_info, container, false);


        RecyclerView recyclerView = view.findViewById(R.id.rvEvents);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.mainActivity));
        adapter = new EventsRecyclerViewAdapter(eventsList);

        recyclerView.setAdapter(adapter);
        return view;
    }


}