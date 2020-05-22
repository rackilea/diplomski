{
        final Target mTarget = new Target() {
            @Override
            public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
                Log.d("DEBUG", "onBitmapLoaded");
                 Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, 50, 50, false);
                 mBitmapDrawable = new BitmapDrawable(getResources(), scaledBitmap);
                 getSupportActionBar().setHomeAsUpIndicator(mBitmapDrawable);
            }

            @Override
            public void onBitmapFailed(Exception e, Drawable errorDrawable) {

            }
            @Override
            public void onPrepareLoad(Drawable drawable) {
                Log.d("DEBUG", "onPrepareLoad");
            }
        };
        Picasso.get().load("http://192.168.1.53:8080/Farid/1.jpg").into(mTarget);

}
    getSupportActionBar().setHomeButtonEnabled(true);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);