@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    View view =inflater.inflate(R.layout.fragment_frag1, container,false);
    rv= (RecyclerView)view.findViewById(R.id.rv);
    rv.setHasFixedSize(true);
    rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));

    ArrayList<String> words = new ArrayList<>() ;
    words.add("x");
    words.add("x");
    words.add("x");
    adapter= new CardAdapter(getActivity(),words);
    rv.setAdapter(adapter);

    // Return the view that you already inflated:
    return view;
}