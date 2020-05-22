Double sum;
boolean Ceksum;
TextView nomor1;
TextView nomor2;
TextView tanda;
Double no1 = 0d;
Double no2 = 0d;


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    nomor1 = (TextView) findViewById(R.id.Nomor1);
    nomor2 = (TextView) findViewById(R.id.Nomor2);
    tanda = (TextView) findViewById(R.id.tanda);
    no1 = Double.parseDouble(nomor1.getText().toString());
    no2 = Double.parseDouble(nomor2.getText().toString());

}