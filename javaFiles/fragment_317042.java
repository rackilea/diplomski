this.map.setOnCameraChangeListener(new OnCameraChangeListener() {

    public void onCameraChange(CameraPosition arg0) {
      isMapReady = true;
      map.setOnCameraChangeListener(null);
    }
  });