public class Fraction
{
    private int numerator;
    private int denominator;

    public Fraction()
    {    
        this.numerator = 0;
        this.denominator = 1;
    }   

    public Fraction(int n, int r)
    {
        this.numerator = n;
        this.denominator = r;
    }

    public Fraction add(Fraction f)
    {

        // System.out.println(this.numerator);
        // System.out.println(this.numerator);

        int n = this.numerator;
        int d = this.denominator;

        this.numerator = n * f.denominator + f.numerator * d;
        this.denominator = d * f.denominator;

        // System.out.println(this.numerator + " : this.numerator");
        // System.out.println(this.denominator + " : this.denominator");
        // System.out.println(f.numerator + " : f.numerator");
        // System.out.println(f.denominator + " : f.denominator");

        return this;
    }

    public Fraction multiply(Fraction f)   
    {
        this.numerator = this.numerator * f.numerator;
        this.denominator = this.denominator * f.denominator;   
        return this;
    }

    public void printIt()
    {
        System.out.println(this.numerator + "/" + this.denominator);
    }

    public void printAsDouble()
    {
        double d;
        d = (1.0 * this.numerator / this.denominator);
        System.out.println(d);
    }


}