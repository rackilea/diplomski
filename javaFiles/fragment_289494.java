String names[] = {"Pa", "An", "Du", "De"};
  String pass[] = {"P", "A", "D", "S"};
  String gender[] = {"Female", "Female", "Female", "Male"};


  Button button;
  EditText n, p;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_account);

    button = (Button) findViewById(R.id.login);
    n = (EditText) findViewById(R.id.name);

    p = (EditText) findViewById(R.id.pass);

    button.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        String nn = n.getText().toString();
        String pp = p.getText().toString();

        int index = 0;
        int i;
        for (i = 0; i < names.length; i++) {

          if (nn.equals(names[i])) {
            index = i;

            if (pp.equals(pass[index])) {

              Context context = getApplicationContext();
              CharSequence text = "Login Successful!";
              int duration = Toast.LENGTH_SHORT;

              Toast toast = Toast.makeText(context, text, duration);
              toast.show();

              Intent intent = new Intent(Account.this, MainPage.class);
              startActivity(intent);

            }
            if (!(pp.equals(pass[index]))) {

              Context context = getApplicationContext();
              CharSequence text = "Incorrect Password";

              int duration = Toast.LENGTH_SHORT;

              Toast toast = Toast.makeText(context, text, duration);
              toast.show();
            }
            break; //add break here
          }

        }
        if (i == names.length) {
          Context context = getApplicationContext();
          CharSequence text = "Incorrect Username!";
          int duration = Toast.LENGTH_SHORT;

          Toast toast = Toast.makeText(context, text, duration);
          toast.show();
        }

      }
    });
  }