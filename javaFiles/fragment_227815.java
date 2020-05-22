@Override
public void onSuccess(Uri uri) {
    ColorDrawable cd = new ColorDrawable(ContextCompat.getColor(MapsActivity.this, R.color.wallet_holo_blue_light));
    Glide.with(MapsActivity.this)
        .load(uri.toString())
        .asBitmap()
        .listener(new RequestListener<String, Bitmap>() {
            @Override
            public boolean onException(Exception e, String model, Target<Bitmap> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, String model, Target<Bitmap> target, boolean isFromMemoryCache, boolean isFirstResource) {
                marker = mMap.addMarker(new MarkerOptions()
                    .position(new LatLng(post.latitude, post.longitude))
                    .title(post.title)
                    .icon(BitmapDescriptorFactory.fromBitmap(resource))
                );
                return true;
            }
        })
        .placeholder(cd)
        .centerCrop()
        .preload();    
}