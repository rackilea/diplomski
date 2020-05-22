protected double computePitch(View view)
{
    if (view == null)
        return 0.0;

    if (!(view instanceof OrbitView))
        return 0.0;

    OrbitView orbitView = (OrbitView) view;
    return orbitView.getPitch().getDegrees();
}