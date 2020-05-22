public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.your_layout, container, false);

    ImageView imageView = (ImageView) view.findViewById(R.id.image_view); 

    return view;
}