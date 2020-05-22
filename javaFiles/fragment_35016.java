class MainActivity extends AppCompatActivity() {
    private ArrayList fileEntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fileEntry = new ArrayList();

        starting_button = (Button) findViewById(R.id.button_start);
        starting_button.setOnClickListener(new View.OnClickListener() {
    }

    @Override
    public void onClick(View v) {
        // Do something with your fileEntry
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        fileEntry.add(sensorEvent.values[0] + "," + sensorEvent.values[1] + "," + sensorEvent.values[2] + "\r");
    }    
}