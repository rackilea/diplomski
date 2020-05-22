@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);
    ViewGroup viewGroup = (ViewGroup) findViewById(R.id.myLayout);
    Button dalsi_akce = new Button(this);
    dalsi_akce.setGravity(Gravity.CENTER);
    RelativeLayout.LayoutParams p = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.WRAP_CONTENT,
            RelativeLayout.LayoutParams.WRAP_CONTENT);
    dalsi_akce.setLayoutParams(p);
    dalsi_akce.setText("test");


    viewGroup.addView(dalsi_akce);
}