setContentView(R.layout.activity_main);
    // add
    RelativeLayout mainLayout = (RelativeLayout)findViewById(R.id.layoutnameinXML);

    TextView myLocation = (TextView)findViewById(R.id.txtAddress);
    myLocation.setText("123 Main St New York, NY");
    Linkify.addLinks(myLocation , Linkify.MAP_ADDRESSES);
    mainLayout.addView(myLocation);