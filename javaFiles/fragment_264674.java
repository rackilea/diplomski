@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                     Bundle savedInstanceState) {

fragment_layout = inflater.inflate(R.layout.fragment_offers, container, false);

// Offers RecyclerView
        offersRecycler = fragment_layout.findViewById(R.id.offersRecycler);
        offers = new ArrayList();
        offers_init();
        offersAdapter = new OffersAdapter(offers,getContext());
        offersRecycler.setAdapter(offersAdapter);
        offersRecycler.setLayoutManager(new LinearLayoutManager(getContext()));


// Inflate the layout for this fragment
return inflater.inflate(R.layout.fragment_offers, container, false);
}