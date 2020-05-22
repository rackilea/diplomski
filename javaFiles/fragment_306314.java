// create variables
Intent intent;
TextView labelView;

// init textview in onCreate
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    labelView = (TextView) findViewById(R.id.labelView);
}

// initialize intent in onClick
public void onClick(View v) {
    switch(v.getId()) {
        case R.id.imageButtonInfo:
            intent = new Intent(MainActivity.this, InfoActivity.class);
            MainActivity.this.startActivity(intent);
            break;
    }
}