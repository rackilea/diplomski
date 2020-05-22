Button chkCmd;
ToggleButton passTog;
EditText input;
TextView display;
@Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    setContentView(R.layout.text);

    chkCmd = (Button) findViewById(R.id.bResults);
    passTog = (ToggleButton) findViewById(R.id.tbPassword);
    input = (EditText) findViewById(R.id.etCommands);
    display = (TextView) findViewById(R.id.tvResults);
}