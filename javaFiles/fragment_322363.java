private TextView timeText;
private TextView dateText;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.new_task);

    timeText = (TextView) findViewById(R.id.timeTxt);
    dateText = (TextView) findViewById(R.id.dateTxt);

    Button btnSave = (Button) findViewById(R.id.btnSave);
    if (btnSave != null) {
        btnSave.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            }
        });
    } else {
        Log.e("MyActivity", "btnSave was null :(");
    }
}