private int[] textures = new int[3];
    public void loadtexture(GL10 gl, Context mContext, String map_source) {
            try {
InputStream is = mContext.getAssets().open(map_source);
            Bitmap bitmap2 = BitmapFactory.decodeStream(is);
            is.close();
            Matrix flip = new Matrix();
            flip.postScale(1f, -1f);
            Bitmap bitmap =  Bitmap.createBitmap(bitmap2, 0, 0, bitmap2.getWidth(), bitmap2.getHeight(), flip, true);
            bitmap2.recycle();
... (same like before)