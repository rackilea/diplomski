ImageView imageView1 = new ImageView(LookActivity.this);

imageView1.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent event) {
        detectLocationAndShowPopUp((ImageView) view);
        return true;
    }
});