public class Equilateral extends Triangle
{
    public Equilateral(double sideA)
    {
        super(sideA, sideA, sideA);
    }
}

public class IsoscelesRight extends Triangle
{
    public IsoscelesRight(double sideA)
    {
        super(sideA, sideA, Math.sqrt(2*sideA*sideA));
    }
}