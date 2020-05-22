OrbitView viewbounds = (OrbitView)wwd.getView();
if (viewbounds != null)
{
    OrbitViewLimits limits = viewbounds.getOrbitViewLimits();
    if (limits != null)
    {
        viewLimit = new Sector();// Fill with appropriate bounds
        limits.setCenterLocationLimits(viewLimit);
        limits.setPitchLimits(Angle.fromDegrees(0), Angle.fromDegrees(90));
        //^in degrees downward from looking directly at the earth
        limits.setHeadingLimits(Angle.ZERO, Angle.ZERO);// rotation cw or ccw
        limits.setZoomLimits(minZoom, maxZoom);// in meters
        BasicOrbitViewLimits.applyLimits(viewbounds, limits);
    }
}