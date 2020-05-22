private OnClickCallback onClickCallback;

@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

    view = inflater.inflate(R.layout.fragment_form4, container, false);

    onClickCallback = this;



    list = new ArrayList<>();
    list.add(new POJOcarviewFotoForm4(R.drawable.ic_person_black_24dp,"Picture"));
    list.add(new POJOcarviewFotoForm4(R.drawable.ic_person_black_24dp,"Picture"));
    list.add(new POJOcarviewFotoForm4(R.drawable.ic_person_black_24dp,"Picture"));
    list.add(new POJOcarviewFotoForm4(R.drawable.ic_person_black_24dp,"Picture"));
    list.add(new POJOcarviewFotoForm4(R.drawable.ic_person_black_24dp,"Picture"));


    RecyclerView recyclerView=(RecyclerView)view.findViewById(R.id.form4_recyclerview);
    RecyclerViewAdapterFotoForm4 adapterFotoForm4=new RecyclerViewAdapterFotoForm4(getContext(),list);
    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
    recyclerView.setAdapter(adapterFotoForm4, onClickCallback);

    return view;
}