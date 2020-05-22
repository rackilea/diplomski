/// Returns the azimuth of the sun in rad. Azimuth is the angle between a line to south and the sun.
    private float sunAzimuth(float solarTime, float solarDeclination, float latitude) {
    return (float)-(atan2((-cos(solarDeclination) * sin(PI * solarTime / 12)),
        (cos(latitude) * sin(solarDeclination) - sin(latitude) * cos(solarDeclination) *
        cos(PI * solarTime / 12.0))));
}