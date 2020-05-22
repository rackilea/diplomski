private Button button_convert;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    button_convert= (Button) findViewById(R.id.button_convert);
    onClick_Convert();
}

public void onClick_Convert() {

    button_convert.setOnClickListener (
            new View.OnClickListener() {

                @Override
                public void onClick (View v) {
                    Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                }
            }
    );
}