import java.math.BigDecimal;

public class TestingStuff {

    public static void main(String[] args){
        BigDecimal d2 = new BigDecimal(0); // to load the big decimal class outside the loop
        long start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            BigDecimal d = new BigDecimal(99);
            d2 = d.movePointRight(2);
        }
        long end = System.currentTimeMillis();
        System.out.println("movePointRight: " + (end - start));

        BigDecimal ten = new BigDecimal(10);
        start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            BigDecimal d = new BigDecimal(99);
            d2 = d.multiply(ten).multiply(ten);
        }
        end = System.currentTimeMillis();
        System.out.println("multiply: " + (end - start));

        start = System.currentTimeMillis();
        for(int i = 0; i < 1000000; i++) {
            BigDecimal d = new BigDecimal(99);
            d2 = d.scaleByPowerOfTen(2);
        }
        end = System.currentTimeMillis();
        System.out.println("scaleByPowerOfTen: " + (end - start));
    }

}