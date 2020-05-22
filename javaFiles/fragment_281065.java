public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.article_view, container, false);
        playButton = (Button) view.findViewById(R.id.playButton);
        //set onclicklisteners
        return view;
}