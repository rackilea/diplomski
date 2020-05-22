@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.test);

    boolean isLandscape = this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE;
    ((ImageView)findViewById(R.id.background)).setImageResource(isLandscape ? R.drawable.background_l : R.drawable.background_p);

    getText();
}