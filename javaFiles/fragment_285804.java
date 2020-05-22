@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);

    // add 'final'
    final EditText wiekEditText = (EditText) findViewById(R.id.inWiek);
    final EditText tspoczEditText = (EditText) findViewById(R.id.inTspocz);

    // remove offending code

    final EditText tempWiekEdit = wiekEditText;
    TabHost tabHost = (TabHost) findViewById(R.id.tabHost);

    ...

    final Button Btn = (Button) findViewById(R.id.Btn);      
    Btn.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            // move the parsing code here
            int Tmax, RT;
            int wiek = Integer.parseInt(wiekEditText.getText().toString());
            int tspocz = Integer.parseInt(tspoczEditText.getText().toString());

            Tmax = 220 - wiek;
            RT = Tmax - tspocz;
            Wynik = 70*RT/100 + tspocz;

            Toast.makeText(getApplicationContext(),"blablabla"+ Wynik,Toast.LENGTH_SHORT).show();
        }
    });

    ...

}