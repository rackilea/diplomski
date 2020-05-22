public class Fraction
{
    private final int num
    private final int denom;

    public Franction(int n, int d)
    {
        this.num = n;
        this.denom = d;
    }

    @Override
    String toString() 
    {
        return String.format("%d/%d", num, denom);
    }

    public static void main(String[] args)
    {
        Fraction f1 = new Fraction(5,10);
        System.out.println("Fraction = " + f1);
    }
}