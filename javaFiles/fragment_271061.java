int[] imageIds = {R.drawable.sticky,
        R.drawable.sticky1,
        R.drawable.sticky2,
        R.drawable.sticky3,
        R.drawable.sticky4,
        R.drawable.sticky5,
        R.drawable.sticky6,
        R.drawable.sticky7
};


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    requestWindowFeature(Window.FEATURE_NO_TITLE);
    setContentView(R.layout.activity_sticky_home);

    RelativeLayout layout = (RelativeLayout)findViewById(R.id.colourSticky);
    Random genorator = new Random();
    int randomImageId =imageIds[genorator.nextInt(imageIds.length)];
    layout.setBackgroundResource(randomImageId);

}