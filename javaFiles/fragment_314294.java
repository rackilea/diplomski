@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view=inflater.inflate(R.layout.activity_friend_list,container,false);

    recyclerView= (RecyclerView) view.findViewById(R.id.RecyclerViewForFriendList);
    recyclerView.setHasFixedSize(true);
    layoutManager=new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);

    AsyncUserResponse listener = new AsyncUserResponse() {
        @Override
        public void onUsersReceived(List<User> users) {
            adapter=new RecyclerFriendListAdapter(getActivity(), users);
            recyclerView.setAdapter(adapter);
        }
    };

    new GetUsersTask(listener).execute();


    return view;
}