class ComplexNum
{
    int a,b;

    ComplexNum(int a , int b)
    {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString()
    {
        return a + "+" + b + "i";
    }

    public static void main(String[] args)
    {
        ComplexNum c = new ComplexNum(10,12);
        System.out.println("Complex Number is: " + c);
    }
}