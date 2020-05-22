@Override
      public void onChildChanged(DataSnapshot snapshot, String s) {

       LatLng latLng = new LatLng(snapshot.getValue(TestUserStudent.class).getLat(), 
       snapshot.getValue(TestUserStudent.class).getLang());
       boolean show = snapshot.getValue(TestUserStudent.class).isShow();

       if(show)
        {
             studentMarker = googleMap.addMarker(new MarkerOptions()
            .position(latLng)
            .title(item.getValue(TestUserStudent.class).getName() + "")
            .snippet(item.getValue(TestUserStudent.class).getSection() + "")
            .icon(BitmapDescriptorFactory.fromBitmap(
             getMarkerBitmapFromView(item.getValue(TestUserStudent.class)
              .getImg(), R.drawable.redMarker))));
             studentMarkersList.add(studentMarker);
        }



      }