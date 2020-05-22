if (e.getButton() == MouseEvent.BUTTON1) {
    Point p = e.getPoint();
    int X = p.x+3;
    int Y = p.y+3;
    List<MapMarker> ar = map.getMapMarkerList();
    Iterator<MapMarker> i = ar.iterator();
    while (i.hasNext()) {

        MyMapMarkerDot mapMarker = (MyMapMarkerDot) i.next();

        if(mapMarker.position != null){

            int centerX =  mapMarker.position.x;
            int centerY = mapMarker.position.y;

            // calculate the radius from the touch to the center of the dot
            double radCircle  = Math.sqrt( (((centerX-X)*(centerX-X)) + (centerY-Y)*(centerY-Y)));

            // if the radius is smaller then 23 (radius of a ball is 5), then it must be on the dot
            if (radCircle < 8){
                ShowClickedUser(mapMarker.Tag);
            }

        }
    }
}