@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    rlRoot = (RelativeLayout) findViewById(R.id.rl_root_splash_activity);

    fillableLoader = (FillableLoader) findViewById(R.id.fillableLoader);
    fillableLoader.setSvgPath(Const.Paths.INDOMINUS_REX);
}