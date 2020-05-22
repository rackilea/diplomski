@Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final TableLayout tableLayout = (TableLayout) findViewById(R.id.table);

    inputRow(tableLayout, "Name", 30, 10000);
    inputRow(tableLayout, "Email", 20, 10001);

    Button doneButton = (Button) findViewById(R.id.done_btn);

    doneButton.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View v) {
        //if you do not have a reference to the EditText already -- this uses the IDs in your question
        EditText nameEditText = (EditText) tableLayout.findViewById(10000);
        EditText emailEditText = (EditText) tableLayout.findViewById(10001);
        String nameValue = nameEditText.getText().toString();
        String emailValue = emailEditText.getText().toString();

        // now you can do whatever you need to with the values
        AlertDialog dialog = new AlertDialog.Builder(MainActivity.this)
            .setTitle("Your Inputs")
            .setMessage("Name is: " + nameValue + ", Email is: " + emailValue)
            .create();
        dialog.show();
      }
    });
  }