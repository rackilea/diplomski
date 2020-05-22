import org.apache.commons.math.util.MathUtils;

...

public static double computeE(){
    return IntStream.iterate(0,k->k+1)
                    .limit(100000)
                    .mapToDouble(k->(3-4*k*k)/MathUtils.factorialDouble(2*k+1))
                    .parallel()
                    .sum();
}