@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.activity_main, container, false);
            feedListView= (ListView) rootView.findViewById(R.id.custom_list);

            String url = "...";
            new DownloadFilesTask().execute(url);
            feedListView.setAdapter(new CustomListAdapter(this, feedList));
            return rootView;
     }