private ObjectAnimator anim;

      @Override
      protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.property_animations_flow);

        ImageView someImage = (ImageView) findViewById(R.id.some_image);

        anim = ObjectAnimator.ofFloat(someImage, "rotation", 0, 360);
        anim.setDuration(1000);
        anim.setRepeatCount(5);
        anim.setRepeatMode(ObjectAnimator.RESTART);
      }

}