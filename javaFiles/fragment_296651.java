@Override
public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        googleMap.setOnCameraMoveListener(new GoogleMap.OnCameraMoveListener() {
              @Override
                public void onCameraMove() {
        System.out.println(mMap.getCameraPosition().target.latitude);
        System.out.println(mMap.getCameraPosition().target.longitude);
        }
      });
   }