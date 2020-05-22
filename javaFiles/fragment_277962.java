SimpleStringAdapter adapter;
ArrayList<String> items = new ArrayList<>();
ListView addressList;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_search_address); 

    addressList = (ListView) findViewById(R.id.addressList);
    addressBox = (EditText) findViewById(R.id.addressBox);

    adapter = new SimpleStringAdapter(this, items);
    addressList.setAdapter(adapter);

    //Search for locations when the user types in
    addressBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(final CharSequence s, int start, int before, int count) {
                //Search the typed location
                SearchAddresses(searchText);
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
    });
}

private void SearchAddresses(String searchText) {
    Geocoder geoCoder = new Geocoder(this, Locale.getDefault());
    try {
        List<Address> addresses =     geoCoder.getFromLocationName(searchText, 5);
        addressList.setAdapter(null);

        if (addresses.size() != 0) {
            //Add the Address line to the list
            items.add(addresses.get(0).getAddressLine(0));
            //Populate the listview
            adapter.notifyDataSetChanged();

        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}