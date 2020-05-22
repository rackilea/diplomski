private PolygonOptions createPolygonWithHoles(List<List<LatLng>> holes) {

    PolygonOptions polyOptions = new PolygonOptions()
            .fillColor(0x33000000) /*sample fill color*/
            .addAll(getEarthlyBound()) /*the bounds of the earth*/
            .strokeColor(0xFF000000) /*sample stroke color*/
            .strokeWidth(5); /*sample stroke width*/

    for (List<LatLng> hole : holes) {
        polyOptions.addHole(hole);
    }

    return polyOptions;
}