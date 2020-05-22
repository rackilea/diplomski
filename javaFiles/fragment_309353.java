public void onWindowFocusChanged(boolean hasFocus) {
    // TODO Auto-generated method stub
    super.onWindowFocusChanged(hasFocus);
     if (hasFocus) {
        ImageView img = (ImageView) findViewById(R.id.img);
        Log.d(TAG, "width : " + img.getWidth());
     }

    }