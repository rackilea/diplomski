static float metersToLatitude(Position near, float meters) {
    return meters / 110.6*1000;
}

static float metersToLongitude(Position near, float meters) {
    float lat = Math.toRadians(near.latitude);
    return meters /
        (111132.954 - 559.822 * Math.cos(2*lat) + 1.175 * Math.cos(4*lat));
}