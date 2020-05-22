import java.math.BigDecimal;
public class Test {
    public static void main(String args[]) {
        BigDecimal b1 = new BigDecimal(0.01);
        BigDecimal b2 = new BigDecimal(0.01);
        BigDecimal b3 = new BigDecimal(0);
        if (b1.compareTo(b2) == 0) System.out.println("equal 1");
        b1 = b1.subtract(b2);
        if (b1.compareTo(b3) == 0) System.out.println("equal 2");
        System.out.println("BigDecimal result: "+ b1);
    }                          
}