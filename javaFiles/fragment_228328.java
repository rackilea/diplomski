@Override
protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    rlRoot = (RelativeLayout) findViewById(R.id.rl_root_splash_activity);

    FillableLoaderBuilder loaderBuilder = new FillableLoaderBuilder();
    fillableLoader = loaderBuilder
            .parentView(rlRoot)
            .svgPath(Const.Paths.INDOMINUS_REX)
            .layoutParams(new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT))
            .originalDimensions(970, 970)
            .strokeColor(Color.parseColor("#1c9ade"))
            .fillColor(Color.parseColor("#1c9ade"))
            .strokeDrawingDuration(2000)
            .clippingTransform(new WavesClippingTransform())
            .fillDuration(10000)
            .build();
    fillableLoader.setSvgPath(Paths.INDOMINUS_REX);
}