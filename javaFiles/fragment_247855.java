public class favaoritesFragment extends Fragment {
    public static TextView data;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_favorites,container,false);
        RecyclerView  mRecyclerView = view.findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        mRecyclerView.setAdapter(mAdapter);
        ArrayList<Status> statusArrayList = new ArrayList<>();
        statusArrayList.add(new Status(R.drawable.ic_action_name,"Line2","Line3"));
        statusArrayList.add(new Status(R.drawable.common_google_signin_btn_icon_dark_focused,"Line2","Line3"));
        statusArrayList.add(new Status(R.drawable.ic_action_name,"Line2","Line3"));

        mAdapter = new RecyclerAdapter(statusArrayList);
        mAdapter.notifyDataSetChanged();
  　　　return view;
    }

}