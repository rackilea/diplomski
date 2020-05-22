@Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_add_deadline);
    String data = getIntent().getExtras().getString("date");

    editDate = (EditText)findViewById(R.id.editText3);
editDate.setText(date);


}