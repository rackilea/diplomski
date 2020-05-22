@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
  setSupportActionBar(toolbar);

  FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
  fab.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
      Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show();

      // remove all the widget stuff and move it outside
    }
  });

  SaveDataButton = (Button) findViewById(R.id.button);
  TextName = (EditText) findViewById(R.id.editText1);
  TextScore = (EditText) findViewById(R.id.editText2);
  //Name = TextName.getText().toString();
  //Score = Integer.parseInt(TextScore.getText().toString());

}