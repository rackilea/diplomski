public static Bitmap loadBitmapFromView(View v) {
          Bitmap b = Bitmap.createBitmap( v.getLayoutParams().width, v.getLayoutParams().height, Bitmap.Config.ARGB_8888);                
          Canvas c = new Canvas(b);
          v.measure(v.getLayoutParams().width, v.getLayoutParams().height); //Change from original post
          v.layout(0, 0, v.getLayoutParams().width, v.getLayoutParams().height);
          v.draw(c);
          return b;
    }