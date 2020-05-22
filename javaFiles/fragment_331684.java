@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    btnStart = (Button) findViewById(R.id.btnStart);
    btnStop = (Button) findViewById(R.id.btnStop);
    textViewTime = (TextView) findViewById(R.id.textViewTime);
    editHours = (EditText) findViewById(R.id.editHours);
    editMinutes = (EditText) findViewById(R.id.editMinutes);
    editSeconds = (EditText) findViewById(R.id.editSeconds);

    btnStart.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Time = 3600 * Integer.parseInt(editHours.getText().toString())
                    + 60
                    * Integer.parseInt(editMinutes.getText().toString())
                    + Integer.parseInt(editSeconds.getText().toString());

            if (timer != null) {
                timer.cancel();
                timer = null;
            }
            timer = new CounterClass(1000 * Time, 1000);

            timer.start();
        }
    });

    btnStop.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            timer.cancel();
            reset();
        }
    });
}
public void reset() {
    if (timer != null) {
        timer.cancel();
    }
    editHours.setText("0");
    editMinutes.setText("0");
    editSeconds.setText("0");
    textViewTime.setText("0");
}