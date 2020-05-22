TextView titletext;
List<Activitytable> activityTable;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_details);

    activityTable = Activitytable.listAll(Activitytable.class);
    titletext = (TextView) findViewById(R.id.titletext);

    Intent i = getIntent();
    if (i != null) {
        String data = i.getStingExtra("listPosition");
        titletext.setText(String.valueOf(data));
    }
}