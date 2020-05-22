@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    super.onCreateView(inflater, container, savedInstanceState);
    View v = inflater.inflate(R.layout.your_layout, container, false);

    tvTitle = (TextView) v.findViewById(R.id.tvTitle);
    ivLogo = (ImageView) v.findViewById(R.id.ivLogo);

    // Each row in the list stores country name, currency and flag 
    List<HashMap<String,String>> aList = new ArrayList<HashMap<String,String>>();

    for(int i=0;i<10;i++){
        HashMap<String, String> hm = new HashMap<String,String>();
        hm.put("txt", "Country : " + countries[i]);
        hm.put("cur","Currency : " + currency[i]);
        hm.put("flag", Integer.toString(flags[i]) );
        aList.add(hm);
    } 

    // Keys used in Hashmap 
    String[] from = { "flag","txt","cur" };

    // Ids of views in listview_layout 
    int[] to = { R.id.flag,R.id.txt,R.id.cur};

    // Instantiating an adapter to store each items 
    // R.layout.listview_layout defines the layout of each item 
    SimpleAdapter adapter = new SimpleAdapter(v.getContext(), aList, R.layout.listview_layout, from, to);

    // Getting a reference to listview of main.xml layout file 
    ListView listView = ( ListView ) v.findViewById(R.id.listview);

    // Setting the adapter to the listView 
    listView.setAdapter(adapter);

    return v;
}