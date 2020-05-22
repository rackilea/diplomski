private LinearLayout top_layout;
private LinearLayout middle_layout;
private final ArrayList<Button> buttonList = new ArrayList<>();

@Override
protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);

  top_layout = (LinearLayout) findViewById(R.id.top_layout);
  middle_layout = (LinearLayout) findViewById(R.id.middle_layout);

  for(int i=0; i<6; i++) {
    final Button b = new Button(this);
    b.setText("" + (i + 1));
    b.setGravity(Gravity.CENTER_HORIZONTAL);
    b.setId(i + 1);
    b.setOnClickListener(clickListener);
    buttonList.add(b);
  }

  shuffleButtons();
}