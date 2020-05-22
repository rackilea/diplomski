public class Lab1 {
    public static void main(String[] args) {
        System.out.println("Input x: ");
        Scanner scan = new Scanner(System.in);
        double x = scan.nextDouble();

        // (3+x)^6
        double a = Math.pow(3+x, 6);        
        // lnx
        double b = Math.log(x);
        // √(3+x)^6 - lnx
        double c = Math.sqrt(a-b);
        //e^0    [something^0 is always = 1, so you could also set it just to 1]
        double e = Math.pow(Math.E, 0);    //double e = 1;
        //arcsin6x^2
        double f = Math.asin(6 * Math.pow(x, 2));

        double k = c / (e+f);        

        System.out.println("Your answer: " + k);
    }
}