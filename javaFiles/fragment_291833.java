class ButterknifeActivity extends Activity {
  @Bind(R.id.title) TextView title;
  @Bind(R.id.logo) ImageView logo;

  @Override public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main_activity);
    ButterKnife.bind(this);
  }
}