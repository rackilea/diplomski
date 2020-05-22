//generate bit map from view
private Bitmap createBitMap(View v) {
    Bitmap b = Bitmap.createBitmap(v.getMeasuredWidth(), v.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
    if (b != null) {
        Canvas c = new Canvas(b);
        v.layout(0, 0, v.getMeasuredWidth(), v.getMeasuredHeight());
        v.draw(c);
    }
    return b;
}

// created user marker with his image
private void addMyLocationMarker() {

View view = DataBindingUtil.inflate(getActivity().getLayoutInflater(), R.layout.layout_marker, null, false);
view.setLayoutParams(new ViewGroup.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT));
view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), View.MeasureSpec.UNSPECIFIED), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight()); 
    if (userMarker != null)
        userMarker = googleMap
                .addMarker(new MarkerOptions()
                        .anchor(0.5F, 0.5F)
                        .position(latlng)
                        .icon(BitmapDescriptorFactory.fromBitmap(createBitMap(bindingUserMarker.getRoot()))));
        userMarker.setZIndex(2f);
        updateUserMarkerImage(view);
    }
}

//update user image
private void updateUserMarkerImage(View view ) {
   ImageView imageView=view.findViewById(R.id.image);
    //load your image using any image loader and recreate marker with your view and set it marker
}