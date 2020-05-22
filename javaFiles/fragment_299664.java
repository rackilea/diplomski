public class HomeFragment extends Fragment {

ArrayList<SectionDataModel> allSampleData;


LadderLayoutManager llm;
RecyclerView.LayoutManager multi_scroll_layout_manager;
RecyclerView rcv,multi_scroll_recyclerview;
HSAdapter adapter;
RecyclerView.Adapter multi_scroll_adapter;
int scrollToPosition;
public HomeFragment() {
    // Required empty public constructor
}



@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    int[] images = {R.drawable.vancouver,R.drawable.party,R.drawable.hands_ip,R.drawable.dj};
    // Inflate the layout for this fragment
           allSampleData = new ArrayList<SectionDataModel>();

            createDummyData();


    HorizontalAdapter firstAdapter = new HorizontalAdapter(images);
    View view = inflater.inflate(R.layout.fragment_home, container, false);
    llm = new LadderLayoutManager(1.5f, 0.85f, LadderLayoutManager.HORIZONTAL).
            setChildDecorateHelper(new LadderLayoutManager
                    .DefaultChildDecorateHelper(getResources().getDimension(R.dimen.item_max_elevation)));
    llm.setChildPeekSize((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
            30, getResources().getDisplayMetrics()));
    llm.setMaxItemLayoutCount(5);

    rcv = (RecyclerView) view.findViewById(R.id.rcv);
    rcv.setLayoutManager(llm);

    new LadderSimpleSnapHelper().attachToRecyclerView(rcv);
    adapter = new HSAdapter();
    rcv.setAdapter(adapter);

    multi_scroll_recyclerview = (RecyclerView)view.findViewById(R.id.multi_scroll_recyclerview);
    multi_scroll_layout_manager = new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false);
    multi_scroll_recyclerview.setLayoutManager(multi_scroll_layout_manager);
    multi_scroll_adapter = new RecyclerViewDataAdapter(getActivity(),allSampleData);
    multi_scroll_recyclerview.setAdapter(multi_scroll_adapter);
    multi_scroll_recyclerview.setHasFixedSize(true);






   /* MultiSnapRecyclerView firstRecyclerView = (MultiSnapRecyclerView)view.findViewById(R.id.first_recycler_view);
    LinearLayoutManager firstManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
    firstRecyclerView.setLayoutManager(firstManager);
    firstRecyclerView.setAdapter(firstAdapter);

    HorizontalAdapter secondAdapter = new HorizontalAdapter(images);
    MultiSnapRecyclerView secondRecyclerView =(MultiSnapRecyclerView) view.findViewById(R.id.second_recycler_view);
    LinearLayoutManager secondManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
    secondRecyclerView.setLayoutManager(secondManager);
    secondRecyclerView.setAdapter(secondAdapter);

    HorizontalAdapter thirdAdapter = new HorizontalAdapter(images);
    MultiSnapRecyclerView thirdRecyclerView = (MultiSnapRecyclerView)view.findViewById(R.id.third_recycler_view);
    LinearLayoutManager thirdManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
    thirdRecyclerView.setLayoutManager(thirdManager);
    thirdRecyclerView.setAdapter(thirdAdapter);*/


    return view;

}
public void createDummyData() {
    for (int i = 1; i <= 5; i++) {

        SectionDataModel dm = new SectionDataModel();

        dm.setHeaderTitle("Section " + i);

        ArrayList<SingleItemModel> singleItem = new ArrayList<SingleItemModel>();
        for (int j = 0; j <= 5; j++) {
            singleItem.add(new SingleItemModel("Item " + j, "URL " + j));
        }

        dm.setAllItemsInSection(singleItem);

        allSampleData.add(dm);//line which is causing issue

    }
  }

}