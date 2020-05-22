protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtAmount = (EditText) findViewById(R.id.txtAmount);
        btnNaira = (Button) findViewById(R.id.btnNaira);
        btnCFA = (Button) findViewById(R.id.btnCFA);
        lblOutput = (TextView) findViewById(R.id.lblOutput);