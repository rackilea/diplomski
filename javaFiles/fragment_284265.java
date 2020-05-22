@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar t = (Toolbar) findViewById(R.id.tool);
    setSupportActionBar(t);
    getSupportActionBar().setDisplayShowTitleEnabled(false);

    //left side button

    Button b = new Button(this);
    Toolbar.LayoutParams l1=new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
    l1.gravity = Gravity.START;
    b.setLayoutParams(l1);
    b.setText("left");
    t.addView(b);

    //center Textview
    TextView text=new TextView(this);
    text.setText("Text:1");
    Toolbar.LayoutParams l2 = new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
    l2.gravity = Gravity.CENTER;
    text.setLayoutParams(l2);
    t.addView(text);

    //Right side button

    Button b1=new Button(this);
    b1.setText("Right");
    Toolbar.LayoutParams l3=new Toolbar.LayoutParams(Toolbar.LayoutParams.WRAP_CONTENT, Toolbar.LayoutParams.WRAP_CONTENT);
    l3.gravity=Gravity.END;
    b1.setLayoutParams(l3);
    t.addView(b1);

}