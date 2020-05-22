@Override
public void onCreate(Bundle savedInstanceState) {
    ...
    super.onCreate(savedInstanceState);

    ViewGroup content = (ViewGroup) findViewById(R.id.event_frame);
    getLayoutInflater().inflate(R.layout.event_main, content, true);
    ...
}