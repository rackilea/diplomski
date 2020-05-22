public class DtaPlusMethods {
    private double a = 1.0;
    private double b = 2.0;
    private double c = 3.0;

    public static void main(String[] args) {
        DtaPlusMethods thisClass= new DtaPlusMethods();
        System.out.println(thisClass.Mean());

    }

    private double Mean()
    {
        c = (a + b)/2;
        return(c);
    }  
}