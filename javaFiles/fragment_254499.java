// Instantiates a new CircleOptions object and defines the center and radius
CircleOptions circleOptions = new CircleOptions()
    .center(new LatLng(POS_LAT, POS_LNG))
    .radius(30) // radius in meters
    .fillColor(0x8800CCFF) //this is a half transparent blue, change "88" for the transparency
    .strokeColor(Color.BLUE) //The stroke (border) is blue
    .strokeWidth(2)); // The width is in pixel, so try it!

// Get back the mutable Circle
Circle circle = myMap.addCircle(circleOptions);