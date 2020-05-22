ImageView imageView1 = new ImageView(LookActivity.this);
final ImageView imageView2 = imageView1;

imageView1.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View arg0, MotionEvent arg1) {
        detectLocationAndShowPopUp(imageView2);
        return true;
    }
});