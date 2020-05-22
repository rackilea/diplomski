public class FactorialExample {
    // The new mult method.
    private static int mult( final int x, final int y ) {
        System.out.println( "Multiplying "+x+" and "+y+"." );
        return x * y;
    }

    public static int fact(int n){
        if (n == 0){
            return 1;
        }else{
            return mult(n, fact(n - 1)); // using the new mult method
        }
    }

    public static void main(String[] args){
      System.out.print(fact(5));
    }
}