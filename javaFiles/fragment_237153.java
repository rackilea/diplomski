private static float distance(LatLng current, LatLng last){
    if(last==null)
        return 0;
    Location cL = new Location("");
    cL.setLatitude(current.latitude);
    cL.setLongitude(current.longitude);

    Location lL = new Location("");
    lL.setLatitude(last.latitude);
    lL.setLongitude(last.longitude);

    return lL.distanceTo(cL);
}