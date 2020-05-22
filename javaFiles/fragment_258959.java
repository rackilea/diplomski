@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
super.onActivityResult(requestCode, resultCode, data);

cropView = (ImageView) findViewById(R.id.editor);
cropView.setDrawingCacheEnabled(true);
//make crop view square
cropView.getLayoutParams().height = cropView.getWidth();
cropView.requestLayout();

if (resultCode == RESULT_OK) {
    try {
        b = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
        cropView.setImageBitmap(b);
    } catch (IOException e) {
        e.printStackTrace();
    }

}

new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setValues();
            }
        },1500);