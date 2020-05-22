@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

     buttonSend = (Button) findViewById(R.id.buttonSend);
    textTo = (EditText) findViewById(R.id.editTextSendTo);
    textSubject = (EditText) findViewById(R.id.editTextName);
    textMessageContact = (EditText) findViewById(R.id.editTextContact);
    textMessageEmail = (EditText) findViewById(R.id.editTextEmail);
    textMessageAmount = (EditText) findViewById(R.id.editTextAmount);
    spinner = (Spinner) findViewById(R.id.spinner);
    buttonSend.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {

            String to = textTo.getText().toString();
            String subject = textSubject.getText().toString();

            Intent email = new Intent(Intent.ACTION_SEND);
            email.putExtra(Intent.EXTRA_EMAIL, new String[] { to });
            email.putExtra(Intent.EXTRA_SUBJECT, subject);
            email.setType("message/rfc822");
            startActivity(Intent.createChooser(email,
                    "Choose an Email client :"));

        }
    });

 if (savedInstanceState == null) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new    PlaceholderFragment()).commit();
    }
}