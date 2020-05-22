ImageView slide;
private Handler handler;
private int showPic = -1;// default value should be -1
Integer[] ids = new Integer[] { R.drawable.red_circle, R.drawable.white_circle};

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.slide_show);
    slide = (ImageView) findViewById(R.id.slide);
    handler = new Handler();
    handler.postDelayed(imageUpdate, 10);
}


private void setNextImage() {
    showPic++;
    if (showPic == ids.length) {
        showPic = -1;
        handler.removeCallbacks(imageUpdate);
    } else {
        slide.setImageResource(ids[showPic]);
        handler.postDelayed(imageUpdate, 1000);
    }
}

Runnable imageUpdate= new Runnable() {
    @Override
    public void run() {
        setNextImage();
    }
};