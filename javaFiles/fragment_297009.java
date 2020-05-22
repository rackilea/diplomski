mapRipple = new MapRipple(mMap, actualUbicacion, this);
mapRipple.withNumberOfRipples(3);
mapRipple.withFillColor(Color.BLUE);
mapRipple.withStrokeColor(Color.BLACK);
mapRipple.withStrokewidth(10);      // 10dp
mapRipple.withDistance(2000);      // 2000 metres radius
mapRipple.withRippleDuration(12000);    //12000ms
mapRipple.withTransparency(0.5f);
mapRipple.startRippleMapAnimation();