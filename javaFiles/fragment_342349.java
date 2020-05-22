protected void onCreate(Bundle savedInstanceState)  {
  super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creazione_sondaggio);
        titolo = (EditText) findViewById(R.id.titolo);
        sceltaA = (EditText) findViewById(R.id.A);
        sceltaB = (EditText) findViewById(R.id.B);
        sceltaC = (EditText) findViewById(R.id.C);
        server= (EditText) findViewById(R.id.server);
       invio = (Button) findViewById(R.id.invia);

       // invio.setOnClickListener(this);


    }