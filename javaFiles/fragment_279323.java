@Override
public void onMapLongClick(LatLng point) {
    thePoint=point;

    Marker marker = googleMap.addMarker(new MarkerOptions()
            .position(thePoint));
     markerId = marker.getId();         

     Intent imageIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
     timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
     File imagesFolder = new File(Environment.getExternalStorageDirectory(), "My Castle");
     imagesFolder.mkdirs();
     image = new File(imagesFolder.getPath(), "Mycastle_" + timeStamp + ".jpg");
     fileUri = Uri.fromFile(image);

     imageIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
     startActivityForResult(imageIntent, TAKE_PICTURE);
}