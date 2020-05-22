@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    view = inflater.inflate(R.layout.fragment_home, container, false); // Created a instance of View which we can return later.

    //cardview
    models = new ArrayList<>();
    models.add(new Model(R.drawable.brochure,"Brochure","Lorem ipsum dolor sit amet"));
    models.add(new Model(R.drawable.sticker,"Sticker","Lorem ipsum dolor sit amet"));
    models.add(new Model(R.drawable.poster,"Poster","Lorem ipsum dolor sit amet"));
    models.add(new Model(R.drawable.namecard,"Name Card","Lorem ipsum dolor sit amet"));

    adapter = new Adapter(models,this);

    viewPager = view.findViewById(R.id.viewPager); // Change getView() to view here.
    viewPager.setAdapter(adapter);
    viewPager.setPadding(130,0,130,0);

    return view; // Returned the view.
}