public class FindNewThingFragment extends android.support.v4.app.Fragment {
    private PullRefreshLayout pullRefreshLayout;
    private ProgressBar progressBar;
    private ListView listView;
    private ArrayList<ThingsItem> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_found_new_thing,container,false);
        listView=(ListView)view.findViewById(R.id.things_item_list_view);
        progressBar=(ProgressBar)view.findViewById(R.id.things_item_progress_bar);
        new LoadDongxiData().execute();

        return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    private class LoadDongxiData extends AsyncTask<Void,Void,Void> {
        public LoadDongxiData(){
            arrayList=new ArrayList<ThingsItem>();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            doSomething();
            for(int i=0;i<10;i++) {
                arrayList.add(new ThingsItem(itemImageUrl, itemName, price, userIconUrl, userName, userComment, numberOfLikes, numberOfAddDouToList, numberOfReply, userHomePageLink, itemDetailLink));
            } 
        }

        protected void onPostExecute(Long result) {
            if(arrayList != null && arrayList.size() > 0) {
                ThingsItemListViewAdapter adapter=new ThingsItemListViewAdapter(getActivity(),arrayList);
                listView.setAdapter(adapter);
            }
        }
    }
}