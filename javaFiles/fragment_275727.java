enum Element
{
    Hydrogen(1.0),
    Helium(2.0),
    ...;

    private double mass;

    private Element(double masss)
    {
        this.mass = mass;
    }

    public double getMasss()
    {
        return mass;
    }
}