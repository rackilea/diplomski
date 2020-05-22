public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    View rootView = inflater.inflate(R.layout.fragment_layout, container, false);
    ...
    EditText myEditText = (EditText) rootView.findViewById(R.id.response_dependent_edittext);
    myEditText.setText("Loading Data");

    ImageView myImageView = (ImageView) rootView.findViewById(R.id.response_dependent_imageview);
    myImageView.setImageResource(R.drawable.image_placeholder);
    ...

    return rootView;
}