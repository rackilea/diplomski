@Override
protected void onCreate(Bundle SecodState) {
    super.onCreate(SecodState);
    setContentView(R.layout.second);

    Button mButtonPlay1, mButtonPlay2, mButtonPlay3;

    mButtonPlay1 = (Button)findViewById(R.id.piano);
    mButtonPlay1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(SecondPage.this, MainActivity.class));
        }
    });

    mButtonPlay2 = (Button)findViewById(R.id.other);
    mButtonPlay2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(SecondPage.this, OtherInd.class));
        }
    });

    mButtonPlay3 = (Button)findViewById(R.id.about_us);
    mButtonPlay3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(SecondPage.this, AboutUs.class));
        }
    });
}