import java.util.function.Function;
public class Trapez {
    static double trapezoidalRule( Function<Double,Double> f, double a, double b, double h ){
        int n = (int)Math.round((b - a)/h) + 1;
        double area = 0;
        double y = f.apply( a );
        for( int i = 1; i < n; i++ ){
            double y1 = f.apply( a + h*i );
            area += 0.5*h*(y + y1);
            y = y1;
        }
        return area;
    }
    public static void main(String[] args) {
        System.out.println( trapezoidalRule( x -> 2*x, 0, 1, 0.1 ) );
    }
}