Button button1;
TextView txtspr;
EditText   urlInputEditText;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    button1=(Button) findViewById(R.id.button);

            txtspr=(TextView)findViewById(R.id.textSprawdzajacy);
            urlInputEditText=(EditText) findViewById(R.id.editText);
    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    });
}

public void onClick(View view) {
        String n=urlInputEditText.getText().toString();
        txtspr.setText(n);
}