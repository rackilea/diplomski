@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_start);

        NextPageStart = (Button) findViewById(R.id.NextStatLocBut);
        mapName = (EditText) findViewById(R.id.MapNameText);

        // To disable the button intially
        NextPageStart.setEnabled(false);

        mapName.addTextChangedListener(textWatcher);

        //Click Listener for button
        NextPageStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // You can do some click action here

            }
        });
    }