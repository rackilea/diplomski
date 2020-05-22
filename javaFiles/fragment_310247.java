@Override
protected void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    Button b = new Button(this);

    b.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            checkTime();
        }
    });

    setContentView(new Button(this));

}