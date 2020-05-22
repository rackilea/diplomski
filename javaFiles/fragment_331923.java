public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.activity_pulau, container,false);

    ListView lv = (ListView) rootView.findViewById(R.id.lv);

    Pil = new String[] {"", "", "", "", ""};
    Ltn = new String[] {"", "", "", "", ""};
    Gbr = new String[] {Integer.toString(R.drawable.coba),
                                 };

    mylist = new ArrayList<HashMap<String,String>>();

    for (int i = 0; i < Pil.length; i++){
        map = new HashMap<String, String>();
        map.put("list", Pil[i]);
        map.put("latin", Ltn[i]);
        map.put("gbr", Gbr[i]);
        mylist.add(map);             
    }

    Adapter = new SimpleAdapter(getActivity(), mylist, R.layout.item_kepulauan,
              new String[] {"list", "latin", "gbr"}, new int[] {R.id.tv_nama, R.id.tv_des, R.id.imV});
    lv.setAdapter(Adapter);

    return rootView;
  }