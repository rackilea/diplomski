private Ship mShip;
private TextView counterText;

protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_my);
    mShip = new Ship();
    counterText = (TextView) findViewById(R.id.counter);
    counterText.setText(String.valueOf(mShip.getCounter()));
}
public void planetClick(View view) {
    int curCounter = mShip.getCounter();
    mShip.setCounter(curCounter + 1);
    counterText.setText(String.valueOf(mShip.getCounter()));
}