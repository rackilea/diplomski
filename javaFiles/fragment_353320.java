public class MyClass {
    public static void main(String[] args){
    double x = 30;
    if(product_n(x)>1000000)
        System.out.println("yes " + product_n(x));

    else
        System.out.println("nope "+ product_n(x));
}
// the following method returns the product of the n first integers(excluding 0)
public static double product_n(double n)
{
    double product = 1;
    if (n<=0)
        return 0;
    for(double i = n; i>(n-n);i--)
        product *=i;
    return product;
}
}