class YourClass {
    Marker singleMarker; //marker to be removed

    public void addMarker() {
        ....
        //here you add your marker
        singleMarker = mMap.addMarker(camion);
    }

    public void removeSingleMarker() {
        if(singleMarker != null) {
            singleMarker.remove();
            singleMarker = null;
        }
    }
}