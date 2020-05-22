@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.text);

    Button chkCmd = (Button) findViewById(R.id.bResults);
    ToggleButton passTog = (ToggleButton) findViewById(R.id.tbPassword);
    EditText input = (EditText) findViewById(R.id.etCommands);
    TextView display = (TextView) findViewById(R.id.tvResults);
}