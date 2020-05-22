private Route directions(final GeoPoint start, final GeoPoint dest) {
    Parser parser;
    //https://developers.google.com/maps/documentation/directions/#JSON <- get api
    String jsonURL = "http://maps.googleapis.com/maps/api/directions/json?";
    final StringBuffer sBuf = new StringBuffer(jsonURL);
    sBuf.append("origin=");
    sBuf.append(start.getLatitudeE6()/1E6);
    sBuf.append(',');
    sBuf.append(start.getLongitudeE6()/1E6);
    sBuf.append("&destination=");
    sBuf.append(dest.getLatitudeE6()/1E6);
    sBuf.append(',');
    sBuf.append(dest.getLongitudeE6()/1E6);
    sBuf.append("&sensor=true&mode=driving");
    parser = new GoogleParser(sBuf.toString());
    Route r =  parser.parse();
    return r;
}