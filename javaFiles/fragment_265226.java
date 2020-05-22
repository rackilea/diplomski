@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    // select an layout to inflate
    View view = inflater.inflate(R.layout.fragment_a,container,false);

    Resources res = getResources();
    sLikes=res.getStringArray(R.array.likes);
    sTimes=res.getStringArray(R.array.times);

    // call the views with this layout
    list = (ListView) view.findViewById(R.id.listView1); 
    // you see, you need to find the view with "view.find..."

    sAdapter adapter = new sAdapter(getActivity(), sLikes, images, sTimes);
    list.setAdapter(adapter);

    // return the view
    return view;
}