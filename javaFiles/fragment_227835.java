@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    ViewGroup mView = (ViewGroup) inflater.inflate(R.layout.fragment_main, container, false);
    btnFetch = (Button) mView.findViewById(R.id.btnSearch);
    txtSearch = (EditText) mView.findViewById(R.id.txtSearch);

    btnFetch.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            JsonHandler handler = new JsonHandler();
            handler.fetchImages(txtSearch.getText().toString());
        }
    });

    return mView;
}